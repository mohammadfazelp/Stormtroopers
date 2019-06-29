package com.faz.stormtroopers.di.module.commented

//package com.faz.stormtroopers.di.module
//
//import android.app.Application
//import android.content.Context
//import com.faz.data.cache.PreferencesHelper
//import com.faz.data.cache.TripCache
//import com.faz.data.repository.ICache
//import dagger.Module
//import dagger.Provides
//import javax.inject.Singleton
//
//@Module
//class LocalModule {
//
//    @Provides
//    @Singleton
//    fun provideContext(application: Application): Context {
//        return application
//    }
//
//    @Provides
//    @Singleton
//     fun providePreferencesHelper(context: Context): PreferencesHelper {
//        return PreferencesHelper(context)
//    }
//
//    @Provides
//    @Singleton
//     fun provideTripCache(helper: PreferencesHelper): ICache {
//        return TripCache(helper)
//    }
//}