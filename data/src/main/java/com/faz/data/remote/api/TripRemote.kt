package com.faz.data.remote.api

import com.faz.data.remote.model.TripEntity
import com.faz.data.repository.IRemote
import io.reactivex.Single
import javax.inject.Inject

/**
 * Remote implementation for retrieving Trip instances. This class implements the
 * [IRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class TripRemote @Inject constructor(private val api: TripApi): IRemote{

    /**
     * Retrieve a list of [TripEntity.Trip] instances from the [TripApi].
     */
    override fun getTrips(): Single<TripApi.TripListResponse> {
        return api.getTrips()
    }

    /**
     * Retrieve a [TripEntity.Trip] instance from the [TripApi].
     */
    override fun getTripById(id: Long): Single<TripEntity.Trip> {
        return api.getTripById(id)
    }
}
