package com.faz.domain.usecase.trip

import com.faz.domain.IRepository
import com.faz.domain.executor.PostExecutionThread
import com.faz.domain.executor.ThreadExecutor
import com.faz.domain.model.TripModel
import com.faz.domain.test.factory.TripFactory
import com.faz.domain.usecase.GetTripsUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class GetTripsTest {

    private lateinit var getTrips: GetTripsUseCase

    private lateinit var mockThreadExecutor: ThreadExecutor
    private lateinit var mockPostExecutionThread: PostExecutionThread
    private lateinit var mockRepository: IRepository

    @Before
    fun setUp() {
        mockThreadExecutor = mock()
        mockPostExecutionThread = mock()
        mockRepository = mock()
        getTrips = GetTripsUseCase(mockRepository, mockThreadExecutor,
                mockPostExecutionThread)
    }

    @Test
    fun buildUseCaseObservableCallsRepository() {
        getTrips.buildUseCaseObservable(/*null*/)
        verify(mockRepository).getTrips()
    }

    @Test
    fun buildUseCaseObservableCompletes() {
        stubTripRepositoryGetTrips(Single.just(TripFactory.makeTripList(2)))
        val testObserver = getTrips.buildUseCaseObservable(/*null*/).test()
        testObserver.assertComplete()
    }

    @Test
    fun buildUseCaseObservableReturnsData() {
        val trips = TripFactory.makeTripList(2)
        stubTripRepositoryGetTrips(Single.just(trips))
        val testObserver = getTrips.buildUseCaseObservable(/*null*/).test()
        testObserver.assertValue(trips)
    }

    private fun stubTripRepositoryGetTrips(single: Single<List<TripModel.Trip>>) {
        whenever(mockRepository.getTrips())
                .thenReturn(single)
    }

}