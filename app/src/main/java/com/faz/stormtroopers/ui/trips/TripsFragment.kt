package com.faz.stormtroopers.ui.trips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.faz.presentation.model.TripView
import com.faz.presentation.viewmodel.TripsViewModel
import com.faz.stormtroopers.R
import com.faz.stormtroopers.common.extension.observe
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TripsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    private val viewModel: TripsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(TripsViewModel::class.java)
    }

    private var tripList: List<TripView.Trip> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? = inflater.inflate(
        R.layout.fragment_trips, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observe(viewModel.tripsMutableLiveData, ::trips)
        observe(viewModel.networkErrorMutableLiveData, ::networkError)
        viewModel.getTrips()
    }

    private fun networkError(s: @ParameterName(name = "t") String?) {
    }

    private fun trips(list: @ParameterName(name = "t") List<TripView.Trip>?) {
    }

    private fun initView() {
    }
}