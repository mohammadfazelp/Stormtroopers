package com.faz.stormtroopers.di.module

import android.app.Application
import android.content.Context
import com.faz.data.cache.IPreferencesHelper
import com.faz.data.cache.PreferencesHelper
import com.faz.data.datastore.DataStoreFactory
import com.faz.data.executor.JobExecutor
import com.faz.data.mapper.TripMapper
import com.faz.data.remote.api.TripApi
import com.faz.data.remote.api.TripApiFactory
import com.faz.data.remote.api.TripRemote
import com.faz.data.repository.IRemote
import com.faz.data.repository.TripRepository
import com.faz.domain.repository.IRepository
import com.faz.domain.executor.PostExecutionThread
import com.faz.domain.executor.ThreadExecutor
import com.faz.domain.usecase.GetTripsUseCase
import com.faz.domain.usecase.IGetTripsUseCase
import com.faz.stormtroopers.BuildConfig
import com.faz.stormtroopers.UiThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TripsModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideGetTripsUseCase(r: IRepository, t: ThreadExecutor, p: PostExecutionThread)
            : IGetTripsUseCase = GetTripsUseCase(r, t, p)

    @Provides
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    fun provideTripRepository(
        factory: DataStoreFactory,
        mapper: TripMapper
    ): IRepository {
        return TripRepository(factory, mapper)
    }

    /**-----------------Api-------------------**/
    @Provides
    @Singleton
    fun provideTripApi(): TripApi {
        return TripApiFactory.makeTripApi(BuildConfig.DEBUG)
    }


    @Provides
    fun provideTripRemote(api: TripApi): IRemote {
        return TripRemote(api)
    }
    /**-----------------Api-------------------**/

    /**-----------------Local-------------------**/
    @Provides
    @Singleton
    fun providePreferencesHelper(context: Context): IPreferencesHelper {
        return PreferencesHelper(context)
    }

//    @Provides
//    @Singleton
//    fun provideTripCache(helper: PreferencesHelper): ICache {
//        return TripCache(helper)
//    }
    /**-----------------Local-------------------**/

}
