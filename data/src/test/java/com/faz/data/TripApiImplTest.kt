package com.faz.data

import com.faz.data.remote.api.TripApi
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
class TripApiImplTest {

    private lateinit var tripApi: TripApi

    private lateinit var remoteImpl: TripRemote

    @Before
    fun setup() {
        tripApi = mock()
        remoteImpl = TripRemote(tripApi)
    }

    @Test
    fun getTripsCompletes() {
        stubTripServiceGetTrips(Single.just(TripFactory.makeTripResponse()))
        val testObserver = remoteImpl.getTrips().test()
        testObserver.assertComplete()
    }

    @Test
    fun getTripsReturnsData() {
        val response = TripFactory.makeTripResponse()
        stubTripServiceGetTrips(Single.just(response))
        val tripEntities = mutableListOf<TripEntity.Trip>()
        response.forEach {
            tripEntities.add(it)
        }

        val testObserver = remoteImpl.getTrips().test()
        testObserver.assertValue(tripEntities)
    }

    private fun stubTripServiceGetTrips(single: Single<List<TripEntity.Trip>>) {
        whenever(tripApi.getTrips())
            .thenReturn(single)
    }
}