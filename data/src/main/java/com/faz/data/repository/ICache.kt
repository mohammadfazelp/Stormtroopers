package com.faz.data.repository

import com.faz.data.remote.model.TripEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Interface defining methods for the caching of Trips. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */

interface ICache{
    /**
     * Retrieve a list of Trip, from the cache
     */
    fun getTrips(): Single<List<TripEntity.Trip>>

    /**
     * Retrieve a Trip, from the cache
     */
    fun getTripsById(id : Long): Single<TripEntity.Trip>

    /**
     * Save a given list of Trip to the cache
     */
    fun saveTrips(trips: List<TripEntity.Trip>): Completable

//    /**
//     * Save a given Trip to the cache
//     */
//    fun saveTrip(trip: TripEntity.Trip): Completable

    /**
     * Clear all Trips from the cache
     */
    fun clearTrips(): Completable

    /**
     * Checks if an element (User) exists in the cache.
     * @param userId The id used to look for inside the cache.
     * *
     * @return true if the element is cached, otherwise false.
     */
    fun isCached(): Boolean

    /**
     * Checks if an element (User) exists in the cache.

     * @param userId The id used to look for inside the cache.
     * *
     * @return true if the element is cached, otherwise false.
     */
    fun setLastCacheTime(lastCache: Long)

    /**
     * Checks if the cache is expired.

     * @return true, the cache is expired, otherwise false.
     */
    fun isExpired(): Boolean
}