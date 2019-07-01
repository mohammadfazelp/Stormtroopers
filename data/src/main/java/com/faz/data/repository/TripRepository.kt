package com.faz.data.repository

import com.faz.data.mapper.TripMapper
import com.faz.data.datastore.DataStoreFactory
import com.faz.domain.repository.IRepository
import com.faz.domain.model.TripModel
import io.reactivex.Single
import javax.inject.Inject

/**
 * Provides an implementation of the [TripRepository] interface for communicating to and from
 * data sources
 */
class TripRepository @Inject constructor(
    private val factory: DataStoreFactory,
    private val mapper: TripMapper
) :
    IRepository {
    override fun getTrips(): Single<List<TripModel.Trip>> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getTrips()
//            .flatMap {
//                if (dataStore is RemoteDataStore) {
//                    saveTripEntities(it).toSingle { it }
//                } else {
//                    Single.just(it)
//                }
//            }
            .map { list ->
                list.map { listItem ->
                    mapper.mapFromEntity(listItem)
                }
            }
    }

//    private fun saveTripEntities(trips: List<TripEntity.Trip>): Completable {
//        return factory.retrieveCacheDataStore().saveTrips(trips)
//    }

    override fun getTripById(id: Long): Single<TripModel.Trip> {

        val dataStore = factory.retrieveDataStore()
        return dataStore.getTripById(id)
            .map { item ->
                mapper.mapFromEntity(item)
            }
    }

}