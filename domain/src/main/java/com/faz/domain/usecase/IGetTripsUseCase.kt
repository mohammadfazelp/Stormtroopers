package com.faz.domain.usecase

import com.faz.domain.model.TripModel
import io.reactivex.Single

interface IGetTripsUseCase {
    fun buildUseCaseObservable(): Single<List<TripModel.Trip>>
}