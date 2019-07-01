package com.faz.stormtroopers.ui.trips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.faz.presentation.mapper.TripMapper
import com.faz.presentation.model.TripView
import com.faz.presentation.viewmodel.TripsViewModel
import com.faz.stormtroopers.common.extension.observe
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_trips.*
import javax.inject.Inject
import androidx.recyclerview.widget.DividerItemDecoration
import com.faz.stormtroopers.R
import com.faz.stormtroopers.common.extension.affectOnItemClicks
import androidx.navigation.Navigation

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
        setUpObserver()
        setupRecycler()
        viewModel.getTrips()
    }

    private fun setUpObserver() {
        observe(viewModel.tripsMutableLiveData, ::trips)
        observe(viewModel.networkErrorMutableLiveData, ::networkError)
    }

    private fun networkError(s: @ParameterName(name = "t") String?) {
        Toast.makeText(activity, s, Toast.LENGTH_SHORT).show()
    }

    private fun trips(list: @ParameterName(name = "t") List<TripView.Trip>?) {
        if (list != null) {
            tripList = list
            adapter.trips = list
            adapter.notifyDataSetChanged()
        }
    }

    private fun setupRecycler() {
        rv_trips.layoutManager = LinearLayoutManager(activity)
        rv_trips.adapter = adapter
        addDividerToRV()
        rv_trips.affectOnItemClicks { position, view ->
            navigateToDetail(position)
        }
    }

    private fun addDividerToRV() {
        val dividerItemDecoration = DividerItemDecoration(
            rv_trips.context,
            (rv_trips.layoutManager as LinearLayoutManager).orientation
        )
        context?.resources?.getDrawable(R.drawable.divider)?.let { dividerItemDecoration.setDrawable(it) }
        rv_trips.addItemDecoration(dividerItemDecoration)
    }

    private fun navigateToDetail(position: Int) {
        val args = Bundle()
        args.putSerializable("trip", tripList[position])
        val navController = Navigation.findNavController(activity!!, R.id.fragment_trips)
        navController.navigate(R.id.navigateToTripDetailFragment, args)
    }
}