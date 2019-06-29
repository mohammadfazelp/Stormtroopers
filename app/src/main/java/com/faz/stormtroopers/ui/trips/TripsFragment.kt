package com.faz.stormtroopers.ui.trips

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.faz.presentation.model.TripView
import com.faz.stormtroopers.R
import com.faz.stormtroopers.databinding.FragmentTripsBinding
import com.faz.presentation.viewmodel.TripsViewModel
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TripsFragment : DaggerFragment() {

    /**
     * ViewModelFactory has a list of ViewModels and will provide
     * the corresponding ViewModel in this fragment.
     **/
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentTripsBinding

//    lateinit var viewModel: TripsViewModel

    private val viewModel: TripsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(TripsViewModel::class.java)
    }

    private var tripList: List<TripView.Trip> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_trips, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * In our FragmentModule, we defined TripsFragment injection? So we need
         * to call this method in order to inject the ViewModelFactory into our Fragment
         * */
        AndroidSupportInjection.inject(this)
        initViewModel()
    }

    private fun initViewModel() {

//        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TripsViewModel::class.java)
        viewModel.tripsMutableLiveData.observe(this, Observer { list ->
            tripList = list
        })
        viewModel.networkErrorMutableLiveData.observe(
            this, Observer { t -> Toast.makeText(context, t, Toast.LENGTH_SHORT).show() })
        viewModel.getTrips()
    }

    private fun initView() {
    }
}