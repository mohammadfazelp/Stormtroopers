package com.faz.stormtroopers.ui.trips

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.faz.data.remote.api.TripConstants
import com.faz.presentation.model.TripView
import com.faz.stormtroopers.R
import com.squareup.picasso.Picasso
import javax.inject.Inject

class TripsAdapter @Inject constructor() : RecyclerView.Adapter<TripsAdapter.ViewHolder>() {

    var trips: List<TripView.Trip> = arrayListOf()

    companion object {
        const val VIEW_TYPE_WITH_RATE = 0
        const val VIEW_TYPE_WITHOUT_RATE = 1
    }

    override fun getItemViewType(position: Int): Int {
        if (trips[position].pilot.rating != 0.toFloat())
            return VIEW_TYPE_WITH_RATE
        return VIEW_TYPE_WITHOUT_RATE
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trip = trips[position]
        holder.nameText.text = trip.pilot.name
        holder.pickUpText.text = trip.pick_up.name
        holder.dropOffText.text = trip.drop_off.name

        Picasso.get()
            .load(TripConstants.BASE_URL + trip.pilot.avatar)
            .into(holder.picImg)

        if (trip.pilot.rating != 0.toFloat()) holder.ratingBar?.rating = trip.pilot.rating
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout: Int = if (viewType == VIEW_TYPE_WITH_RATE) R.layout.item_trip_with_rate
        else R.layout.item_trip
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return trips.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var picImg: ImageView
        var nameText: TextView
        var pickUpText: TextView
        var dropOffText: TextView
        var ratingBar: RatingBar? = null

        init {
            picImg = view.findViewById(R.id.imageViewPic)
            nameText = view.findViewById(R.id.textViewName)
            pickUpText = view.findViewById(R.id.textViewPickUp)
            dropOffText = view.findViewById(R.id.textViewDropOff)
            try {
                ratingBar = view.findViewById(R.id.ratingBar)
            } catch (exception: Exception) {
            }
        }
    }
}