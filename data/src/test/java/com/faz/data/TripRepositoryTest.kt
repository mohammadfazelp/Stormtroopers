package com.faz.data

import com.faz.data.datastore.CacheDataStore
import com.faz.data.datastore.DataStoreFactory
import com.faz.data.datastore.RemoteDataStore
import com.faz.data.mapper.TripMapperData
import com.faz.data.remote.model.TripEntity
import com.faz.data.repository.IDataStore
import com.faz.data.repository.TripRepository
import com.faz.data.test.factory.TripFactory
import com.faz.domain.model.TripModel
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TripRepositoryTest {

    private lateinit var tripRepository: TripRepository

    private lateinit var tripDataStoreFactory: DataStoreFactory
    private lateinit var tripMapper: TripMapperData
    private lateinit var tripCacheDataStore: CacheDataStore
    private lateinit var tripRemoteDataStore: RemoteDataStore
    private lateinit var dataStore: IDataStore

    @Before
    fun setUp() {
        tripDataStoreFactory = mock()
        tripMapper = mock()
        tripCacheDataStore = mock()
        tripRemoteDataStore = mock()
        tripRepository = TripRepository(tripDataStoreFactory, tripMapper)
//        stubTripDataStoreFactoryRetrieveCacheDataStore()
        stubTripDataStoreFactoryRetrieveRemoteDataStore()
    }

//    @Test
//    fun clearTripsCompletes() {
//        stubTripCacheClearTrips(Completable.complete())
//        val testObserver = tripRepository.clearTrips().test()
//        testObserver.assertComplete()
//    }

//    @Test
//    fun clearTripsCallsCacheDataStore() {
//        stubTripCacheClearTrips(Completable.complete())
//        tripRepository.clearTrips().test()
//        verify(tripCacheDataStore).clearTrips()
//    }

//    @Test
//    fun clearTripsNeverCallsRemoteDataStore() {
//        stubTripCacheClearTrips(Completable.complete())
//        tripRepository.clearTrips().test()
//        verify(tripRemoteDataStore, never()).clearTrips()
//    }

//    @Test
//    fun saveTripsCompletes() {
//        stubTripCacheSaveTrips(Completable.complete())
//        val testObserver = tripRepository.saveTrips(
//            TripFactory.makeTripModelList(2)
//        ).test()
//        testObserver.assertComplete()
//    }

//    @Test
//    fun saveTripsCallsCacheDataStore() {
//        stubTripCacheSaveTrips(Completable.complete())
//        tripRepository.saveTrips(TripFactory.makeTripModelList(2)).test()
//        verify(tripCacheDataStore).saveTrips(any())
//    }

//    @Test
//    fun saveTripsNeverCallsRemoteDataStore() {
//        stubTripCacheSaveTrips(Completable.complete())
//        tripRepository.saveTrips(TripFactory.makeTripModelList(2)).test()
//        verify(tripRemoteDataStore, never()).saveTrips(any())
//    }

//    @Test
//    fun getTripsCompletes() {
//        stubTripDataStoreFactoryRetrieveDataStore(tripCacheDataStore)
//        stubTripCacheDataStoreGetTrip(
//            Single.just(
//                TripFactory.makeTripEntityList(2)
//            )
//        )
//        val testObserver = tripRepository.getTrips().test()
//        testObserver.assertComplete()
//    }

//    @Test
//    fun getTripsReturnsData() {
//        stubTripDataStoreFactoryRetrieveDataStore(tripCacheDataStore)
//        val trips = TripFactory.makeTripModelList(2)
//        val tripEntities = TripFactory.makeTripEntityList(2)
//        trips.forEachIndexed { index, trip ->
//            stubTripMapperMapFromEntity(tripEntities[index], trip)
//        }
//        stubTripCacheDataStoreGetTrip(Single.just(tripEntities))
//
//        val testObserver = tripRepository.getTrips().test()
//        testObserver.assertValue(trips)
//    }

//    @Test
//    fun getTripsSavesTripsWhenFromCacheDataStore() {
//        stubTripDataStoreFactoryRetrieveDataStore(tripCacheDataStore)
//        stubTripCacheSaveTrips(Completable.complete())
//        tripRepository.saveTrips(TripFactory.makeTripModelList(2)).test()
//        verify(tripCacheDataStore).saveTrips(any())
//    }

//    @Test
//    fun getTripsNeverSavesTripsWhenFromRemoteDataStore() {
//        stubTripDataStoreFactoryRetrieveDataStore(tripRemoteDataStore)
//        stubTripCacheSaveTrips(Completable.complete())
//        tripRepository.saveTrips(TripFactory.makeTripModelList(2)).test()
//        verify(tripRemoteDataStore, never()).saveTrips(any())
//    }

//    private fun stubTripCacheSaveTrips(completable: Completable) {
//        whenever(tripCacheDataStore.saveTrips(any()))
//            .thenReturn(completable)
//    }

//    private fun stubTripCacheDataStoreGetTrip(single: Single<List<TripEntity.Trip>>) {
//        whenever(tripCacheDataStore.getTrips())
//            .thenReturn(single)
//    }

    private fun stubTripRemoteDataStoreGetTrips(single: Single<List<TripEntity.Trip>>) {
        whenever(tripRemoteDataStore.getTrips())
            .thenReturn(single)
    }

//    private fun stubTripCacheClearTrips(completable: Completable) {
//        whenever(tripCacheDataStore.clearTrips())
//            .thenReturn(completable)
//    }

//    private fun stubTripDataStoreFactoryRetrieveCacheDataStore() {
//        whenever(tripDataStoreFactory.retrieveCacheDataStore())
//            .thenReturn(tripCacheDataStore)
//    }

    private fun stubTripDataStoreFactoryRetrieveRemoteDataStore() {
        whenever(tripDataStoreFactory.retrieveRemoteDataStore())
            .thenReturn(dataStore)
    }

    private fun stubTripDataStoreFactoryRetrieveDataStore(dataStore: IDataStore) {
        whenever(tripDataStoreFactory.retrieveDataStore())
            .thenReturn(dataStore)
    }

    private fun stubTripMapperMapFromEntity(
        tripEntity: TripEntity.Trip,
        tripModel: TripModel.Trip
    ) {
        whenever(tripMapper.mapFromEntity(tripEntity))
            .thenReturn(tripModel)
    }

}