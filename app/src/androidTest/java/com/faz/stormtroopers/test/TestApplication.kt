package com.faz.stormtroopers.test

import android.app.Activity
import android.app.Application
import androidx.test.InstrumentationRegistry
import com.faz.stormtroopers.injection.component.TestApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject
//import com.faz.stormtroopers.injection.component.DaggerTestAppComponent

class TestApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>

    private lateinit var appComponent: TestApplicationComponent

    override fun onCreate() {
        super.onCreate()
//        appComponent = DaggerTestAppComponent.builder().application(this).build()
        appComponent.inject(this)
    }

    companion object {

        fun appComponent(): TestApplicationComponent {
            return (InstrumentationRegistry.getTargetContext().applicationContext as TestApplication).
                appComponent
        }
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return injector
    }

}