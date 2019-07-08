package com.faz.stormtroopers.injection.module

import android.app.Application
import android.content.Context
import com.faz.data.cache.IPreferencesHelper
import com.faz.data.executor.JobExecutor
import com.faz.data.remote.api.TripApi
import com.faz.data.repository.IRemote
import com.faz.domain.executor.PostExecutionThread
import com.faz.domain.executor.ThreadExecutor
import com.faz.domain.repository.IRepository
import com.faz.domain.usecase.IGetTripsUseCase
import com.faz.stormtroopers.UiThread
import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class TestTripsModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun provideGetTripsUseCase(): IGetTripsUseCase {
        return mock()
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
    fun provideTripRepository(): IRepository {
        return mock()
    }

    /**-----------------Api-------------------**/
    @Provides
    @Singleton
    fun provideTripApi(): TripApi {
        return mock()
    }


    @Provides
    fun provideTripRemote(api: TripApi): IRemote {
        return mock()
    }
    /**-----------------Api-------------------**/

    /**-----------------Local-------------------**/
    @Provides
    @Singleton
    internal fun providePreferencesHelper(): IPreferencesHelper {
        return mock()
    }


//    @Provides
//    @Singleton
//    fun provideTripCache(helper: PreferencesHelper): ICache {
//        return TripCache(helper)
//    }
    /**-----------------Local-------------------**/

}

