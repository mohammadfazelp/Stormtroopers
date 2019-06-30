package com.faz.data.source

import com.faz.data.cache.TripCache
import com.faz.data.datastore.CacheDataStore
import com.faz.data.datastore.DataStoreFactory
import com.faz.data.datastore.RemoteDataStore
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TripDataStoreFactoryTest {

    private lateinit var dataStoreFactory: DataStoreFactory

    private lateinit var tripCache: TripCache
    private lateinit var cacheDataStore: CacheDataStore
    private lateinit var remoteDataStore: RemoteDataStore

    @Before
    fun setUp() {
        tripCache = mock()
        cacheDataStore = mock()
        remoteDataStore = mock()
        dataStoreFactory = DataStoreFactory(
            tripCache,
            cacheDataStore, remoteDataStore
        )
    }

    @Test
    fun retrieveDataStoreWhenNotCachedReturnsRemoteDataStore() {
        stubTripCacheIsCached(false)
        val dataStore = dataStoreFactory.retrieveDataStore()
        assert(dataStore is RemoteDataStore)
    }

    @Test
    fun retrieveDataStoreWhenCacheExpiredReturnsRemoteDataStore() {
        stubTripCacheIsCached(true)
        stubTripCacheIsExpired(true)
        val dataStore = dataStoreFactory.retrieveDataStore()
        assert(dataStore is RemoteDataStore)
    }

    @Test
    fun retrieveDataStoreReturnsCacheDataStore() {
        stubTripCacheIsCached(true)
        stubTripCacheIsExpired(false)
        val dataStore = dataStoreFactory.retrieveDataStore()
        assert(dataStore is CacheDataStore)
    }

    @Test
    fun retrieveRemoteDataStoreReturnsRemoteDataStore() {
        val dataStore = dataStoreFactory.retrieveRemoteDataStore()
        assert(dataStore is RemoteDataStore)
    }

    @Test
    fun retrieveCacheDataStoreReturnsCacheDataStore() {
        val dataStore = dataStoreFactory.retrieveCacheDataStore()
        assert(dataStore is CacheDataStore)
    }

    private fun stubTripCacheIsCached(isCached: Boolean) {
        whenever(tripCache.isCached())
            .thenReturn(isCached)
    }

    private fun stubTripCacheIsExpired(isExpired: Boolean) {
        whenever(tripCache.isExpired())
            .thenReturn(isExpired)
    }
}