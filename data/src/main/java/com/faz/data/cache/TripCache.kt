package com.faz.data.cache

import com.faz.data.remote.api.TripApi
import com.faz.data.remote.model.TripEntity
import com.faz.data.repository.ICache
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class TripCache @Inject constructor(private val preferencesHelper: PreferencesHelper)
    : ICache {

    override fun getTrips(): Single<TripApi.TripListResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTripsById(id: Long): Single<TripEntity.Trip> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveTrips(trips: TripApi.TripListResponse): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearTrips(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCached(): Boolean {
        //  TODO("not implemented")
        return false
    }

    override fun setLastCacheTime(lastCache: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isExpired(): Boolean {
        //  TODO("not implemented")
        return true
    }
}