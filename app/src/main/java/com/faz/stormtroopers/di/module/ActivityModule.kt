package com.faz.stormtroopers.di.module

import com.faz.stormtroopers.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [TripsFragmentModule::class])
    abstract fun get(): MainActivity
}