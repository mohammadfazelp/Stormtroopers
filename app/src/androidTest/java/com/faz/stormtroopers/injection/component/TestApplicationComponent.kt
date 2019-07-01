package com.faz.stormtroopers.injection.component

import android.app.Application
import com.faz.domain.repository.IRepository
import com.faz.domain.executor.PostExecutionThread
import com.faz.stormtroopers.test.TestApplication
import com.faz.stormtroopers.di.AppComponent
import com.faz.stormtroopers.di.qualifier.PerApplication
import com.faz.stormtroopers.injection.module.TestApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = arrayOf(
    TestApplicationModule::class, /*ActivityBindingModule::class,*/
    AndroidSupportInjectionModule::class))
@PerApplication
interface TestApplicationComponent : AppComponent {

    fun rep(): IRepository

    fun postExecutionThread(): PostExecutionThread

    fun inject(application: TestApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): TestApplicationComponent.Builder

        fun build(): TestApplicationComponent
    }

}