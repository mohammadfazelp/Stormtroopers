package com.faz.stormtroopers.injection.component

import android.app.Application
import com.faz.domain.repository.IRepository
import com.faz.domain.executor.PostExecutionThread
import com.faz.stormtroopers.test.TestApplication
import com.faz.stormtroopers.di.AppComponent
import com.faz.stormtroopers.di.module.*
import com.faz.stormtroopers.di.qualifier.PerApplication
import com.faz.stormtroopers.injection.module.TestAppModule
import com.faz.stormtroopers.injection.module.TestTripsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@PerApplication
@Singleton
@Component(
    modules = [
        TestAppModule::class,
        ActivityModule::class,
        TestTripsModule::class,
        FragmentModule::class,
        ViewModelModule::class,
        AndroidSupportInjectionModule::class]
)
interface TestAppComponent : AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): TestAppComponent
    }

    fun inject(app: TestApplication)

    fun rep(): IRepository

    fun postExecutionThread(): PostExecutionThread
}

