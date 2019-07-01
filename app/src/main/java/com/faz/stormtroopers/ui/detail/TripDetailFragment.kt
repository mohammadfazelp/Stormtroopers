package com.faz.stormtroopers.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.faz.data.remote.api.TripConstants
import com.faz.presentation.model.TripView
import com.faz.stormtroopers.R
import com.faz.stormtroopers.common.extension.calculateTime
import com.faz.stormtroopers.common.extension.convertDuration
import com.faz.stormtroopers.common.extension.numberWithCommas
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerFragment
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_trip_detail.*


class TripDetailFragment : DaggerFragment() {

    lateinit var trip: TripView.Trip

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.fragment_trip_detail, container, false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addData()
        addListener()
    }

    private fun addListener() {
        imageViewBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun addData() {
        try {
            trip = arguments?.get("trip") as TripView.Trip
            textViewName.text = trip.pilot.name
            setPic()
            textViewDurationValue.text = convertDuration(trip.duration)
            if (trip.pilot.rating == 0.toFloat()) {
                textViewNoteRated.visibility = View.VISIBLE
                ratingBar.visibility = View.GONE
            } else {
                ratingBar.rating = trip.pilot.rating
            }
            textViewDepartureValue.text = trip.pick_up.name
            textViewArrivalValue.text = trip.drop_off.name
            textViewDepartureValue.text = trip.pick_up.name
            setTripDistanceValueUsingRx(trip.distance.value)
            setDepartureTimUsingRx(trip.pick_up.date)
            setArrivalTimUsingRx(trip.drop_off.date)

        } catch (exception: Exception) {
        }
    }

    private fun setPic() {
        Picasso.get()
            .load(TripConstants.BASE_URL + trip.pilot.avatar)
            .into(imageViewPic)
    }

    @SuppressLint("CheckResult", "SetTextI18n")
    private fun setTripDistanceValueUsingRx(value: String) {
        Observable.just(value)
            .flatMap {
                return@flatMap Observable.just(numberWithCommas(it))
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                textViewDistanceValue.text = it + " " + trip.distance.unit
            }
    }

    @SuppressLint("CheckResult", "SetTextI18n")
    private fun setDepartureTimUsingRx(value: String) {
        Observable.just(value)
            .flatMap {
                return@flatMap Observable.just(
                    it.replace("T", " ")
                        .replace("Z", " ")
                )
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                textViewDepartureTime.text = calculateTime(it)
            }
    }

    fun gggg() {

    }

    @SuppressLint("CheckResult", "SetTextI18n")
    private fun setArrivalTimUsingRx(value: String) {
        Observable.just(value)
            .flatMap {
                return@flatMap Observable.just(
                    it.replace("T", " ")
                        .replace("Z", " ")
                )
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                textViewArrivalTime.text = calculateTime(it)
            }
    }
}