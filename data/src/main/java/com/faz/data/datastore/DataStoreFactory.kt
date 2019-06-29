package com.faz.data.datastore

import com.faz.data.repository.ICache
import com.faz.data.repository.IDataStore
import javax.inject.Inject

/**
 * Create an instance of a TripDataStore
 */
open class DataStoreFactory @Inject constructor(
    private val cache: ICache,
    private val cacheDataStore:  CacheDataStore,
    private val remoteDataStore:  RemoteDataStore) {

    /**
     * Returns a DataStore based on whether or not there is
     * content in the cache and the cache has not expired
     */
    open fun retrieveDataStore():  IDataStore {
        if (cache.isCached() && !cache.isExpired()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    /**
     * Return an instance of the Remote Data Store
     */
    open fun retrieveCacheDataStore(): IDataStore {
        return cacheDataStore
    }

    /**
     * Return an instance of the Cache Data Store
     */
    open fun retrieveRemoteDataStore(): IDataStore {
        return remoteDataStore
    }
}