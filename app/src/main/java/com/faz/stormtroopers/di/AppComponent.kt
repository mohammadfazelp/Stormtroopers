package com.faz.stormtroopers.di

import android.app.Application
import com.faz.stormtroopers.App
import com.faz.stormtroopers.di.module.*
import com.faz.stormtroopers.di.qualifier.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@PerApplication
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        TripsModule::class,
        AppModule::class,
        FragmentModule::class,
        ViewModelModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}