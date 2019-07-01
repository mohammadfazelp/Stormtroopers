package com.faz.data.cache

import com.faz.data.repository.ICache
import javax.inject.Inject

class TripCache @Inject constructor(private val preferencesHelper: PreferencesHelper)
    : ICache {

//    override fun getTrips(): Single<List<TripEntity.Trip>> {
//    }
//
//    override fun getTripsById(id: Long): Single<TripEntity.Trip> {
//    }
//
//    override fun saveTrips(trips: List<TripEntity.Trip>): Completable {
//    }
//
//    override fun clearTrips(): Completable {
//    }
//
//    override fun isCached(): Boolean {
//        return false
//    }
//
//    override fun setLastCacheTime(lastCache: Long) {
//    }
//
//    override fun isExpired(): Boolean {
//        return true
//    }
}