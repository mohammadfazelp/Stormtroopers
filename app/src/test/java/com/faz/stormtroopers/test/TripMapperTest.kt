package com.faz.stormtroopers.test

import com.faz.presentation.mapper.TripMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class TripMapperTest {

    private lateinit var tripMapper: TripMapper

    @Before
    fun setUp() {
        tripMapper = TripMapper()
    }

    @Test
    fun mapToViewMapsData() {

        val tripModel = TripFactory.makeTripModel()
        val t = tripMapper.mapToView(tripModel)

        assertEquals(tripModel.distance.unit, t.distance.unit)
        assertEquals(tripModel.distance.value, t.distance.value)

        assertEquals(tripModel.drop_off.date, t.drop_off.date)
        assertEquals(tripModel.drop_off.name, t.drop_off.name)
        assertEquals(tripModel.drop_off.picture, t.drop_off.picture)

        assertEquals(tripModel.pick_up.date, t.pick_up.date)
        assertEquals(tripModel.pick_up.name, t.pick_up.name)
        assertEquals(tripModel.pick_up.picture, t.pick_up.picture)

        assertEquals(tripModel.duration, t.duration)
        assertEquals(tripModel.id, t.id)

        assertEquals(tripModel.pilot.avatar, t.pilot.avatar)
        assertEquals(tripModel.pilot.name, t.pilot.name)
        assertEquals(tripModel.pilot.rating, t.pilot.rating)
    }
}