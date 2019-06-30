package com.faz.stormtroopers.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.faz.presentation.viewmodel.TripsViewModel
import com.faz.stormtroopers.di.ViewModelFactory
import com.faz.stormtroopers.di.qualifier.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TripsViewModel::class)
    internal abstract fun bindTripsViewModel(viewModel: TripsViewModel): ViewModel
}