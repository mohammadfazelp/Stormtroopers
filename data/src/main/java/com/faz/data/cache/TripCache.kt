package com.faz.data.cache

import com.faz.data.remote.api.TripApi
import com.faz.data.remote.model.TripEntity
import com.faz.data.repository.ICache
import io.reactivex.Completable
import io.reactivex.Single
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