package com.faz.presentation.mapper

import com.faz.domain.model.TripModel
import com.faz.presentation.model.TripView
import javax.inject.Inject

/**
 * Map a [TripView.Trip] to and from a [TripModel.Trip] instance when data is moving between
 * this layer and the Domain layer
 */
open class TripMapper @Inject constructor() : Mapper<TripView.Trip, TripModel.Trip> {

    /**
     * Map a [TripModel.Trip] instance to a [TripView.Trip] instance
     */
    override fun mapToView(type: TripModel.Trip): TripView.Trip {

        val distance: TripView.Distance = mapFromModelDistance(type.distance)
        val pilot: TripView.Pilot = mapFromModelPilot(type.pilot)
        val pickUp: TripView.Person = mapFromModelPerson(type.pick_up)
        val dropOff: TripView.Person = mapFromModelPerson(type.drop_off)

        return TripView.Trip(type.id,pilot,distance,type.duration,pickUp,dropOff)
    }

    private fun mapFromModelDistance(type: TripModel.Distance): TripView.Distance {
        return TripView.Distance(type.value, type.unit)
    }

    private fun mapFromModelPilot(type: TripModel.Pilot): TripView.Pilot {
        return TripView.Pilot(type.name, type.avatar, type.rating)
    }

    private fun mapFromModelPerson(type: TripModel.Person): TripView.Person {
        return TripView.Person(type.name, type.picture, type.date)
    }
}