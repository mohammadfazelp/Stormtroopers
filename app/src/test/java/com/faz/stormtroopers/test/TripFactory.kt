package com.faz.stormtroopers.test

import com.faz.domain.model.TripModel
import com.faz.stormtroopers.test.DataFactory.Factory.randomFloat
import com.faz.stormtroopers.test.DataFactory.Factory.randomLong
import com.faz.stormtroopers.test.DataFactory.Factory.randomUuid

class TripFactory {

    companion object Factory {

        fun makeTripModel(): TripModel.Trip {
            return TripModel.Trip(
                randomLong(),
                makeTripPilot(),
                makeTripDistance(),
                randomLong(),
                makeTripPerson(),
                makeTripPerson()
            )
        }

        fun makeTripPilot(): TripModel.Pilot {
            return TripModel.Pilot(randomUuid(), randomUuid(), randomFloat())
        }

        fun makeTripDistance(): TripModel.Distance {
            return TripModel.Distance(randomUuid(), randomUuid())
        }

        fun makeTripPerson(): TripModel.Person {
            return TripModel.Person(randomUuid(), randomUuid(), randomUuid())
        }
    }
}