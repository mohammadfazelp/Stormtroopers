package com.faz.stormtroopers.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.faz.presentation.model.TripView
import com.faz.stormtroopers.R
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_trip_detail.*
import javax.inject.Inject

class TripDetailFragment : DaggerFragment() {

    lateinit var trip: TripView.Trip

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment_trip_detail, container, false
    )

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageViewBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
        try {
            trip = arguments?.get("trip") as TripView.Trip
            textViewName.text = trip.pilot.name
            textViewDurationValue.text = trip.duration.toString()
            if (trip.pilot.rating == 0.toFloat()) {
                textViewNoteRated.visibility = View.VISIBLE
                ratingBar.visibility = View.GONE
            } else {
                ratingBar.rating = trip.pilot.rating
            }
            textViewDepartureValue.text = trip.pick_up.name
            textViewArrivalValue.text = trip.drop_off.name
            textViewDepartureValue.text = trip.pick_up.name
            textViewDepartureTime.text = trip.pick_up.date
            textViewArrivalTime.text = trip.drop_off.date
            textViewDistanceValue.text = trip.distance.value + trip.distance.unit
            Picasso.get()
                .load("https://backup-star-wars.herokuapp.com" + trip.pilot.avatar)
                .into(imageViewPic)
        } catch (exception: Exception) {
        }
    }
}