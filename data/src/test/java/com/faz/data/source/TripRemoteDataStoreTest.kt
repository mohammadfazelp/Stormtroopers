package com.faz.data.source

import com.faz.data.datastore.RemoteDataStore
import com.faz.data.remote.api.TripRemote
import com.faz.data.remote.model.TripEntity
import com.faz.data.test.factory.TripFactory
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class TripRemoteDataStoreTest {

    private lateinit var tripRemoteDataStore: RemoteDataStore

    private lateinit var tripRemote: TripRemote

    @Before
    fun setUp() {
        tripRemote = mock()
        tripRemoteDataStore = RemoteDataStore(tripRemote)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun clearTripsThrowsException() {
        tripRemoteDataStore.clearTrips().test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun saveTripsThrowsException() {
        tripRemoteDataStore.saveTrips(TripFactory.makeTripEntityList(2)).test()
    }

    @Test
    fun getTripsCompletes() {
        stubTripCacheGetTrips(Single.just(TripFactory.makeTripEntityList(2)))
        val testObserver = tripRemote.getTrips().test()
        testObserver.assertComplete()
    }

    private fun stubTripCacheGetTrips(single: Single<List<TripEntity.Trip>>) {
        whenever(tripRemote.getTrips())
            .thenReturn(single)
    }
}