package com.faz.data.datastore

import com.faz.data.remote.api.TripApi
import com.faz.data.remote.model.TripEntity
import com.faz.data.repository.IDataStore
import com.faz.data.repository.IRemote
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Implementation of the [IDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class RemoteDataStore @Inject constructor(private val remote: IRemote) :
    IDataStore {

    override fun getTripById(id: Long): Single<TripEntity.Trip> {
        return remote.getTripById(id)
    }

    override fun saveTrips(trips: TripApi.TripListResponse): Completable {
        throw UnsupportedOperationException()
    }

    override fun clearTrips(): Completable {
        throw UnsupportedOperationException()
    }

    /**
     * Retrieve a list of [TripEntity] instances from the API
     */
    override fun getTrips(): Single<TripApi.TripListResponse> {
        return remote.getTrips()
    }
}