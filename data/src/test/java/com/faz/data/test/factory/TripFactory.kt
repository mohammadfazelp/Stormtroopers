package com.faz.data.test.factory

import com.faz.data.remote.api.TripApi
import com.faz.data.remote.model.TripEntity
import com.faz.data.test.factory.DataFactory.Factory.randomFloat
import com.faz.domain.model.TripModel
import com.faz.data.test.factory.DataFactory.Factory.randomInt
import com.faz.data.test.factory.DataFactory.Factory.randomLong
import com.faz.data.test.factory.DataFactory.Factory.randomUuid

class TripFactory {

    companion object Factory {

        fun makeTripEntity(): TripEntity.Trip {
            return TripEntity.Trip(
                randomLong(),
                makeTripPilot(),
                makeTripDistance(),
                randomLong(),
                makeTripPerson(),
                makeTripPerson()
            )
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

        fun makeTripPilot(): TripEntity.Pilot {
            return TripEntity.Pilot(randomUuid(), randomUuid(), randomFloat())
        }

        fun makeTripDistance(): TripEntity.Distance {
            return TripEntity.Distance(randomUuid(), randomUuid())
        }

        fun makeTripPerson(): TripEntity.Person {
            return TripEntity.Person(randomUuid(), randomUuid(), randomUuid())
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

        fun makeTripEntityList(count: Int): List<TripEntity.Trip> {
            val tripEntities = mutableListOf<TripEntity.Trip>()
            repeat(count) {
                tripEntities.add(makeTripEntity())
            }
            return tripEntities
        }

        fun makeTripModelList(count: Int): List<TripModel.Trip> {
            val tripModels = mutableListOf<TripModel.Trip>()
            repeat(count) {
                tripModels.add(makeTripModel())
            }
            return tripModels
        }


        //api package
        fun makeTripResponse(): List<TripEntity.Trip> {
            val tripResponse = TripApi.TripListResponse()
            tripResponse.trips = makeTripApiModelList(5)
            return tripResponse.trips
        }

        fun makeTripApiModelList(count: Int): List<TripEntity.Trip> {
            val tripEntities = mutableListOf<TripEntity.Trip>()
            repeat(count) {
                tripEntities.add(makeTripEntity())
            }
            return tripEntities
        }
    }
}