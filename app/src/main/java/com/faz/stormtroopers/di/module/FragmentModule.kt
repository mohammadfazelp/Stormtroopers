package com.faz.stormtroopers.di.module

import com.faz.stormtroopers.ui.trips.TripsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeTripsFragment(): TripsFragment
}