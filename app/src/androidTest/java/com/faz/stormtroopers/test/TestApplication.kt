package com.faz.stormtroopers.test

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.app.Application
import androidx.test.InstrumentationRegistry
import com.faz.stormtroopers.injection.component.DaggerTestAppComponent
import com.faz.stormtroopers.injection.component.TestAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class TestApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    private lateinit var appComponent: TestAppComponent

    override fun onCreate() {

        super.onCreate()
        appComponent = DaggerTestAppComponent.builder().application(this).build()
        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    companion object {

        fun appComponent(): TestAppComponent {
            return (InstrumentationRegistry.getTargetContext()
                .applicationContext as TestApplication).appComponent
        }
    }
}

