package com.faz.data.datastore

import com.faz.data.remote.model.TripEntity
import com.faz.data.repository.ICache
import com.faz.data.repository.IDataStore
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

open class CacheDataStore @Inject constructor(private val cache: ICache) :
    IDataStore {

    /**
     * Save a given [List] of [TripEntity.Trip] instances to the cache
     */
    override fun saveTrips(trips: List<TripEntity.Trip>): Completable {
        return cache.saveTrips(trips)
            .doOnComplete {
                cache.setLastCacheTime(System.currentTimeMillis())
            }
    }

    /**
     * Clear all Trips from the cache
     */
    override fun clearTrips(): Completable {
        return cache.clearTrips()
    }

    /**
     * Retrieve a list of [TripEntity.Trip] instance from the cache
     */
    override fun getTrips(): Single<List<TripEntity.Trip>> {
        return cache.getTrips()
    }

    /**
     * Retrieve a [TripEntity.Trip] instance from the cache
     */
    override fun getTripById(id: Long): Single<TripEntity.Trip> {
        return cache.getTripsById(id)
    }
}