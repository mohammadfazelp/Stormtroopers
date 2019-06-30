package com.faz.domain.model

sealed class TripModel {

    data class Trip(
        val id: Long,
        val pilot: Pilot,
        val distance: Distance,
        val duration: Long,
//        val pick_up: PickUp,
//        val drop_off: DropOff
        val pick_up: Person,
        val drop_off: Person
    ) : TripModel()

    data class Pilot(
        val name: String,
        val avatar: String,
        val rating: Float
    )

    data class Distance(
        val value: String,
        val unit: String
    )

    //    data class PickUp(
//        val name : String,
//        val picture : String,
//        val date : String
//    )
//
//    data class DropOff(
//        val name : String,
//        val picture: String,
//        val date: String
//    )

    data class Person(
        val name: String,
        val picture: String,
        val date: String
    )
}