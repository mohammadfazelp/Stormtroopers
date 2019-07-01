package com.faz.data.mapper

import com.faz.data.remote.model.TripEntity
import com.faz.data.test.factory.TripFactory
import com.faz.domain.model.TripModel
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TripMapperTest {

    private lateinit var tripMapper: TripMapper

    @Before
    fun setUp() {
        tripMapper = TripMapper()
    }

    @Test
    fun mapFromEntityMapsData() {
        val tripEntity = TripFactory.makeTripEntity()
        val tripModel = tripMapper.mapFromEntity(tripEntity)

        assertTripDataEquality(tripEntity, tripModel)
    }


    private fun assertTripDataEquality(
        tripEntity: TripEntity.Trip,
        tripModel: TripModel.Trip
    ) {
        assertEquals(tripEntity.id, tripModel.id)

        assertEquals(tripEntity.distance.unit, tripModel.distance.unit)
        assertEquals(tripEntity.distance.value, tripModel.distance.value)

        assertEquals(tripEntity.drop_off.date, tripModel.drop_off.date)
        assertEquals(tripEntity.drop_off.name, tripModel.drop_off.name)
        assertEquals(tripEntity.drop_off.picture, tripModel.drop_off.picture)

        assertEquals(tripEntity.pick_up.name, tripModel.pick_up.name)
        assertEquals(tripEntity.pick_up.date, tripModel.pick_up.date)
        assertEquals(tripEntity.pick_up.picture, tripModel.pick_up.picture)

        assertEquals(tripEntity.pilot.avatar, tripModel.pilot.avatar)
        assertEquals(tripEntity.pilot.name, tripModel.pilot.name)
        assertEquals(tripEntity.pilot.rating, tripModel.pilot.rating)

        assertEquals(tripEntity.duration, tripModel.duration)
    }
}