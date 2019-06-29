package com.faz.domain

import com.faz.domain.model.TripModel
import io.reactivex.Single

interface IRepository {

    fun getTrips(): Single<List<TripModel.Trip>>

    fun getTripById(id : Long) : Single<TripModel.Trip>
}