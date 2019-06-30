package com.faz.stormtroopers.ui.trips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.faz.presentation.mapper.TripMapper
import com.faz.presentation.model.TripView
import com.faz.presentation.viewmodel.TripsViewModel
import com.faz.stormtroopers.R
import com.faz.stormtroopers.common.extension.observe
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_trips.*
import javax.inject.Inject

class TripsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var adapter: TripsAdapter
    @Inject
    lateinit var mapper: TripMapper

    private val viewModel: TripsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(TripsViewModel::class.java)
    }

    private var tripList: List<TripView.Trip> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment_trips, container, false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observe(viewModel.tripsMutableLiveData, ::trips)
        observe(viewModel.networkErrorMutableLiveData, ::networkError)
        setupRecycler()
        viewModel.getTrips()
    }

    private fun networkError(s: @ParameterName(name = "t") String?) {
    }

    private fun trips(list: @ParameterName(name = "t") List<TripView.Trip>?) {
        if (list != null) {
            adapter.trips = list
            adapter.notifyDataSetChanged()
        }
    }

    private fun setupRecycler() {
        rv_trips.layoutManager = LinearLayoutManager(activity)
        rv_trips.adapter = adapter
    }

    private fun initView() {
    }
}