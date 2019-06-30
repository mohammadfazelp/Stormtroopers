package com.faz.stormtroopers.ui.trips

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.faz.presentation.model.TripView
import com.faz.stormtroopers.R
import com.squareup.picasso.Picasso
import javax.inject.Inject

class TripsAdapter @Inject constructor(): RecyclerView.Adapter<TripsAdapter.ViewHolder>() {

    var trips: List<TripView.Trip> = arrayListOf()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trip = trips[position]
        holder.nameText.text = trip.pilot.name
        holder.pickUpText.text = trip.pick_up.name
        holder.dropOffText.text = trip.drop_off.name

        Picasso.get()
            .load("https://backup-star-wars.herokuapp.com"+trip.pilot.avatar)
            .into(holder.picImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_trip, parent, false)
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

        init {
            picImg = view.findViewById(R.id.imageViewPic)
            nameText = view.findViewById(R.id.textViewName)
            pickUpText = view.findViewById(R.id.textViewPickUp)
            dropOffText = view.findViewById(R.id.textViewDropOff)
        }
    }

}