package com.faz.stormtroopers.main

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.faz.domain.model.TripModel
import com.faz.stormtroopers.R
import com.faz.stormtroopers.test.TestApplication
import com.faz.stormtroopers.test.factory.TripFactory
import com.faz.stormtroopers.test.util.RecyclerViewMatcher
import com.faz.stormtroopers.ui.MainActivity
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before
import com.faz.stormtroopers.ui.trips.TripsFragment
import org.mockito.junit.MockitoJUnit.rule


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule(
        MainActivity::class.java,
        true, false
    )

    @Rule
    fun rule() = activity

    @Before
    fun setUp() {
        if (rule().activity != null) {
            rule().activity.findNavController(R.id.fragment_trips)
        }
    }

    @Test
    fun checkTextDisplayedInToolbarInFragment() {
//        val fragment = TripsFragment()
//        rule().activity.supportFragmentManager.beginTransaction()
//            .add(R.id.fragment_trips, fragment).commit()

        onView(withId(R.id.textViewToolbarTitle)).check(matches(withText("Last Trips")))
    }

    @Test
    fun activityLaunches() {
        stubTripRepositoryGetTrips(Single.just(TripFactory.makeTripList(2)))
        rule().launchActivity(null)
    }

    @Test
    fun tripsDisplay() {
        val trips = TripFactory.makeTripList(1)
        stubTripRepositoryGetTrips(Single.just(trips))
        rule().launchActivity(null)

        checkTripDetailsDisplay(trips[0], 0)
    }

    @Test
    fun tripsAreScrollable() {
        val trips = TripFactory.makeTripList(20)
        stubTripRepositoryGetTrips(Single.just(trips))
        rule().launchActivity(null)

        trips.forEachIndexed { index, trip ->
            onView(withId(R.id.rv_trips)).perform(
                RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(index)
            )
            checkTripDetailsDisplay(trip, index)
        }
    }

    private fun checkTripDetailsDisplay(trip: TripModel.Trip, position: Int) {
        onView(RecyclerViewMatcher.withRecyclerView(R.id.rv_trips).atPosition(position))
            .check(matches(hasDescendant(withText(trip.pilot.name))))
        onView(RecyclerViewMatcher.withRecyclerView(R.id.rv_trips).atPosition(position))
            .check(matches(hasDescendant(withText(trip.pilot.avatar))))
    }

    private fun stubTripRepositoryGetTrips(single: Single<List<TripModel.Trip>>) {
        whenever(TestApplication.appComponent().rep().getTrips())
            .thenReturn(single)
    }
}