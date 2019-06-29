package com.faz.stormtroopers.di.module

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.faz.domain.executor.PostExecutionThread
import com.faz.domain.executor.ThreadExecutor
import com.faz.domain.model.TripModel
import dagger.Module
import dagger.Provides
import com.faz.stormtroopers.App
import com.faz.stormtroopers.di.qualifier.ApplicationContext
import com.faz.stormtroopers.di.qualifier.PerApplication
import dagger.Binds
import javax.inject.Singleton

/**
 * Module used to provide dependencies at an application-level.
 */
@Module(/*includes = [NetModule::class, LocalModule::class]*/)
abstract class AppModule {

    @ApplicationContext
    @Binds
    abstract fun provideApplicationContext(app: App): Context

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideAppResources(@ApplicationContext context: Context): Resources {
            return context.resources
        }
    }
}
