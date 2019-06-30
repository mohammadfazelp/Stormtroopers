package com.faz.data.repository

import com.faz.data.remote.api.TripApi
import com.faz.data.remote.model.TripEntity
import io.reactivex.Completable
import io.reactivex.Single

interface IDataStore {

    fun getTrips(): Single<List<TripEntity.Trip>>

    fun getTripById(id: Long): Single<TripEntity.Trip>

//    fun saveTrip(id : Long) : Completable

    fun saveTrips(trips: List<TripEntity.Trip>): Completable

    fun clearTrips(): Completable
}