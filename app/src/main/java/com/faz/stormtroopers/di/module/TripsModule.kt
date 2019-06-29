package com.faz.stormtroopers.di.module

import android.app.Application
import android.content.Context
import com.faz.data.cache.PreferencesHelper
import com.faz.data.cache.TripCache
import com.faz.data.datastore.CacheDataStore
import com.faz.data.datastore.DataStoreFactory
import com.faz.data.datastore.RemoteDataStore
import com.faz.data.executor.JobExecutor
import com.faz.data.mapper.Mapper
import com.faz.data.mapper.TripMapperData
import com.faz.data.remote.api.TripApi
import com.faz.data.remote.api.TripApiFactory
import com.faz.data.remote.api.TripRemote
import com.faz.data.remote.model.TripEntity
import com.faz.data.repository.ICache
import com.faz.data.repository.IRemote
import com.faz.data.repository.TripRepository
import com.faz.domain.IRepository
import com.faz.domain.executor.PostExecutionThread
import com.faz.domain.executor.ThreadExecutor
import com.faz.domain.model.TripModel
import com.faz.domain.usecase.GetTripsUseCase
import com.faz.domain.usecase.IGetTripsUseCase
import com.faz.stormtroopers.BuildConfig
import dagger.Module
import dagger.Provides
import com.faz.stormtroopers.UiThread
import com.faz.stormtroopers.di.qualifier.ApplicationContext
import javax.inject.Named
import javax.inject.Singleton

/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
 class TripsModule {

    @Provides
    fun provideGetTripsUseCase(r: IRepository, t: ThreadExecutor, p: PostExecutionThread)
            : IGetTripsUseCase = GetTripsUseCase(r, t, p)

//    @Provides
//    fun provideTripMapper(): Mapper<TripEntity.Trip, TripModel.Trip> = TripMapperData()

    @Provides
    fun provideTripRepository(
        factory: DataStoreFactory,
        mapper: TripMapperData
    ): IRepository {
        return TripRepository(factory, mapper)
    }

    @Provides
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @Singleton
    fun provideTripApi(): TripApi {
        return TripApiFactory.makeTripApi(BuildConfig.DEBUG)
    }

    @Provides
    fun provideTripRemote(api: TripApi): IRemote {
        return TripRemote(api)
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(@ApplicationContext context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }

    @Provides
    @Singleton
    fun provideTripCache(helper: PreferencesHelper): ICache {
        return TripCache(helper)
    }
}
