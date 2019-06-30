package com.faz.data.repository

import com.faz.data.remote.api.TripApi
import com.faz.data.remote.model.TripEntity
import io.reactivex.Single

/**
 * Interface defining methods for the caching of Trips. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface IRemote {

    /**
     * Retrieve a list of Trips, from network
     */
    fun getTrips(): Single<TripApi.TripListResponse>

    /**
     * Retrieve a Trip, from network
     */
    fun getTripById(id :Long): Single<TripEntity.Trip>
}