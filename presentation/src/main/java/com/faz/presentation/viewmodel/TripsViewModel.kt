package com.faz.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faz.domain.model.TripModel
import com.faz.domain.usecase.GetTripsUseCase
import com.faz.presentation.mapper.TripMapper
import com.faz.presentation.model.TripView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class TripsViewModel @Inject constructor(
//    private val getTripsUseCase: SingleUseCase<List<TripModel.Trip>, Void>,
    private val getTripsUseCase: GetTripsUseCase,
    private val tripMapper: TripMapper
) : ViewModel() {

    val tripsMutableLiveData = MutableLiveData<List<TripView.Trip>>()
    val networkErrorMutableLiveData = MutableLiveData<String>()
    private val compositeDisposable = CompositeDisposable()

    fun getTrips() {
        getTripsUseCase.execute(TripSubscriber())
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    inner class TripSubscriber : DisposableSingleObserver<List<TripModel.Trip>>() {

        override fun onSuccess(t: List<TripModel.Trip>) {
            handleSuccess(t)
        }

        override fun onError(exception: Throwable) {
            handleError(exception)
        }
    }

    private fun handleError(exception: Throwable) {
        if (exception.message != null)
            networkErrorMutableLiveData.postValue(exception.message)
    }

    private fun handleSuccess(t: List<TripModel.Trip>) {
        handleGetTripsSuccess(t)
    }

    private fun handleGetTripsSuccess(trips: List<TripModel.Trip>) {
        if (trips.isNotEmpty()) {
            tripsMutableLiveData.postValue(trips.map { tripMapper.mapToView(it) })
        } else {
            networkErrorMutableLiveData.postValue("Network Error!")
        }
    }
}