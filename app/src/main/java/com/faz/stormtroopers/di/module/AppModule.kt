package com.faz.stormtroopers.di.module

import android.content.Context
import android.content.res.Resources
import com.faz.stormtroopers.App
import com.faz.stormtroopers.di.qualifier.ApplicationContext
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [TripsModule::class])
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
