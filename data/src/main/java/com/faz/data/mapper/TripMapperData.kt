package com.faz.data.mapper

import com.faz.data.remote.model.TripEntity
import com.faz.domain.model.TripModel
import javax.inject.Inject

class TripMapperData @Inject constructor() : Mapper<TripEntity.Trip, TripModel.Trip> {

    /**
     * Map a [TripEntity.Trip] instance to a [TripModel.Trip] instance
     */
    override fun mapFromEntity(type: TripEntity.Trip): TripModel.Trip {

        val distance: TripModel.Distance = mapFromEntityDistance(type.distance)
        val pilot: TripModel.Pilot = mapFromEntityPilot(type.pilot)
        val pickUp: TripModel.Person = mapFromEntityPerson(type.pick_up)
        val dropOff: TripModel.Person = mapFromEntityPerson(type.drop_off)

        return TripModel.Trip(type.id, pilot, distance, type.duration, pickUp, dropOff)
    }

    /**
     * Map a [TripModel.Trip] instance to a [TripEntity.Trip] instance
     */
    override fun mapToEntity(type: TripModel.Trip): TripEntity.Trip {

        val distance: TripEntity.Distance = mapToEntityDistance(type.distance)
        val pilot: TripEntity.Pilot = mapToEntityPilot(type.pilot)
        val pickUp: TripEntity.Person = mapToEntityPerson(type.pick_up)
        val dropOff: TripEntity.Person = mapToEntityPerson(type.drop_off)

        return TripEntity.Trip(type.id, pilot, distance, type.duration, pickUp, dropOff)
    }

    private fun mapFromEntityDistance(type: TripEntity.Distance): TripModel.Distance {
        return TripModel.Distance(type.value, type.unit)
    }

    private fun mapFromEntityPilot(type: TripEntity.Pilot): TripModel.Pilot {
        return TripModel.Pilot(type.name, type.avatar, type.rating)
    }

    private fun mapFromEntityPerson(type: TripEntity.Person): TripModel.Person {
        return TripModel.Person(type.name, type.picture, type.date)
    }

    private fun mapToEntityPerson(type: TripModel.Person): TripEntity.Person {
        return TripEntity.Person(type.name, type.picture, type.date)
    }

    private fun mapToEntityPilot(type: TripModel.Pilot): TripEntity.Pilot {
        return TripEntity.Pilot(type.name, type.avatar, type.rating)
    }

    private fun mapToEntityDistance(type: TripModel.Distance): TripEntity.Distance {
        return TripEntity.Distance(type.value, type.unit)
    }
}