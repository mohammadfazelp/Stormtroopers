package com.faz.stormtroopers.injection.module

import android.content.Context
import android.content.res.Resources
import com.faz.stormtroopers.App
import com.faz.stormtroopers.di.qualifier.ApplicationContext
import com.nhaarman.mockito_kotlin.mock
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
//import com.nhaarman.mockito_kotlin.mock


@Module(includes = [TestTripsModule::class])
abstract class TestAppModule {
    @ApplicationContext
    @Binds
    abstract fun provideApplicationContext(app: App): Context

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideAppResources(@ApplicationContext context: Context): Resources {
            return mock()
        }
    }

//    @PerApplication
//    fun provideContext(application: Application): Context {
//        return application
//    }
//
//    @Provides
//    @PerApplication
//    internal fun providePreferencesHelper(): IPreferencesHelper {
//        return mock()
//    }
//
//    @Provides
//    @PerApplication
//    internal fun provideTripRepository(): IRepository {
//        return mock()
//    }
//
//    @Provides
//    @PerApplication
//    internal fun provideTripCache(): ICache {
//        return mock()
//    }
//
//    @Provides
//    @PerApplication
//    internal fun provideTripRemote(): IRemote {
//        return mock()
//    }
//
//    @Provides
//    @PerApplication
//    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
//        return jobExecutor
//    }
//
//    @Provides
//    @PerApplication
//    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
//        return uiThread
//    }
//
//    @Provides
//    @PerApplication
//    internal fun provideTripApi(): TripApi {
//        return mock()
//    }


}