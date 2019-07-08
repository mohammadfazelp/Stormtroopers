package com.faz.presentation.test.factory

import com.faz.domain.model.TripModel
import com.faz.presentation.test.factory.DataFactory.Factory.randomFloat
import com.faz.presentation.test.factory.DataFactory.Factory.randomLong
import com.faz.presentation.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for Trip related instances
 */
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
                randomLong(),
                makeTripModelPilot(),
                makeTripModelDistance(),
                randomLong(),
                makeTripModelPerson(),
                makeTripModelPerson()
            )
        }

        fun makeTripModelPilot(): TripModel.Pilot {
            return TripModel.Pilot(randomUuid(), randomUuid(), randomFloat())
        }

        fun makeTripModelDistance(): TripModel.Distance {
            return TripModel.Distance(randomUuid(), randomUuid())
        }

        fun makeTripModelPerson(): TripModel.Person {
            return TripModel.Person(randomUuid(), randomUuid(), randomUuid())
        }
    }

}