package com.faz.stormtroopers.di

import android.app.Application
import com.faz.stormtroopers.App
import com.faz.stormtroopers.di.module.*
import com.faz.stormtroopers.di.qualifier.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@PerApplication
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        TripsModule::class,
        AppModule::class,
        TripsFragmentModule::class,
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

//@Singleton
//@Component(modules = [
//    AndroidSupportInjectionModule::class,
//    ViewModelModule::class,
//    TripsModule::class,
//    AppModule::class,
//    ActivityModule::class
//])
//interface AppComponent : AndroidInjector<App> {
//    @Component.Builder
//    abstract class Builder : AndroidInjector.Builder<App>()
//}