package com.faz.domain.repository

import com.faz.domain.model.TripModel
import io.reactivex.Single

interface IRepository {

    fun getTrips(): Single<List<TripModel.Trip>>

    fun getTripById(id : Long) : Single<TripModel.Trip>
}