package com.faz.stormtroopers.injection.module

import android.app.Application
import android.content.Context
import com.faz.data.cache.IPreferencesHelper
import com.faz.data.executor.JobExecutor
import com.faz.data.remote.api.TripApi
import com.faz.data.repository.ICache
import com.faz.data.repository.IRemote
import com.faz.domain.repository.IRepository
import com.faz.domain.executor.PostExecutionThread
import com.faz.domain.executor.ThreadExecutor
import com.faz.stormtroopers.UiThread
import com.faz.stormtroopers.di.qualifier.PerApplication
import dagger.Provides
import com.nhaarman.mockito_kotlin.mock

class TestApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(): IPreferencesHelper {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideTripRepository(): IRepository {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideTripCache(): ICache {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideTripRemote(): IRemote {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    internal fun provideTripApi(): TripApi {
        return mock()
    }

}