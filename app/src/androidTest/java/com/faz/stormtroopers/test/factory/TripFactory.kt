package com.faz.stormtroopers.test.factory

import com.faz.domain.model.TripModel
import com.faz.stormtroopers.test.factory.DataFactory

class TripFactory {

    companion object Factory {

        fun makeTripList(count: Int): List<TripModel.Trip> {
            val trips = mutableListOf<TripModel.Trip>()
            repeat(count) {
                trips.add(makeTripModel())
            }
            return trips
        }

        fun makeTripModel(): TripModel.Trip {
            return TripModel.Trip(
                DataFactory.randomLong(),
                makeTripPilot(),
                makeTripDistance(),
                DataFactory.randomLong(),
                makeTripPerson(),
                makeTripPerson()
            )
        }


        fun makeTripPilot(): TripModel.Pilot {
            return TripModel.Pilot(
                DataFactory.randomUuid(),
                DataFactory.randomUuid(),
                DataFactory.randomInt()
            )
        }

        fun makeTripDistance(): TripModel.Distance {
            return TripModel.Distance(
                DataFactory.randomUuid(),
                DataFactory.randomUuid()
            )
        }

        fun makeTripPerson(): TripModel.Person {
            return TripModel.Person(
                DataFactory.randomUuid(),
                DataFactory.randomUuid(),
                DataFactory.randomUuid()
            )
        }
    }
}