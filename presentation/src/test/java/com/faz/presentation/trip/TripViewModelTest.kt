package com.faz.presentation.trip

import com.faz.domain.model.TripModel
import com.faz.presentation.test.factory.TripFactory
import com.faz.domain.usecase.GetTripsUseCase
import com.faz.presentation.mapper.TripMapper
import com.faz.presentation.viewmodel.TripsViewModel
import com.nhaarman.mockito_kotlin.*
import io.reactivex.observers.DisposableSingleObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TripViewModelTest {

    private lateinit var mockTripMapper: TripMapper
    private lateinit var mockGetTrips: GetTripsUseCase

    private lateinit var tripsViewModel: TripsViewModel
    private lateinit var captor: KArgumentCaptor<DisposableSingleObserver<List<TripModel.Trip>>>

    @Before
    fun setup() {
        captor = argumentCaptor<DisposableSingleObserver<List<TripModel.Trip>>>()
        mockTripMapper = mock()
        mockGetTrips = mock()
        tripsViewModel = TripsViewModel(mockGetTrips, mockTripMapper)
    }

    @Test
    fun retrieveTripsHidesErrorState() {
        tripsViewModel.getTrips()
        verify(mockGetTrips).execute(captor.capture(), eq(null))
        captor.firstValue.onSuccess(TripFactory.makeTripList(2))
    }

    @Test
    fun retrieveTripsHidesEmptyState() {
        tripsViewModel.getTrips()
        verify(mockGetTrips).execute(captor.capture(), eq(null))
        captor.firstValue.onSuccess(TripFactory.makeTripList(2))
    }

    @Test
    fun retrieveTripsShowsTrips() {
        val trips = TripFactory.makeTripList(2)
        tripsViewModel.getTrips()
        verify(mockGetTrips).execute(captor.capture(), eq(null))
        captor.firstValue.onSuccess(trips)
    }


    @Test
    fun retrieveTripsShowsEmptyState() {
        tripsViewModel.getTrips()
        verify(mockGetTrips).execute(captor.capture(), eq(null))
//        captor.firstValue.onSuccess(TripFactory.makeTripList(0))
    }

    @Test
    fun retrieveTripsHidesTrips() {
        tripsViewModel.getTrips()
        verify(mockGetTrips).execute(captor.capture(), eq(null))
        captor.firstValue.onSuccess(TripFactory.makeTripList(0))
    }

    @Test
    fun retrieveTripsShowsErrorState() {
        tripsViewModel.getTrips()
        verify(mockGetTrips).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException())
    }

    @Test
    fun retrieveTripsHidesTripsWhenErrorThrown() {
        tripsViewModel.getTrips()
        verify(mockGetTrips).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException())
    }

    @Test
    fun retrieveTripsHidesEmptyStateWhenErrorThrown() {
        tripsViewModel.getTrips()
        verify(mockGetTrips).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException())
    }
}