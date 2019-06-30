package com.faz.data.remote.model

import com.google.gson.annotations.SerializedName

sealed class TripEntity {

    data class Trip(
        @SerializedName("id") val id: Long,
        @SerializedName("pilot") val pilot: Pilot,
        @SerializedName("distance") val distance: Distance,
        @SerializedName("duration") val duration: Long,
        @SerializedName("pick_up") val pick_up: Person,
        @SerializedName("drop_off") val drop_off: Person
//        @SerializedName("pick_up") val pick_up: PickUp,
//        @SerializedName("drop_off") val drop_off: DropOff
    ) : TripEntity()

    data class Pilot(
        @SerializedName("name") val name: String,
        @SerializedName("avatar") val avatar: String,
        @SerializedName("rating") val rating: Float
    )

    data class Distance(
        @SerializedName("value") val value: String,
        @SerializedName("unit") val unit: String
    )

//    data class PickUp(
//        @SerializedName("name") val name: String,
//        @SerializedName("picture") val picture: String,
//        @SerializedName("date") val date: String
//    )
//
//    data class DropOff(
//        @SerializedName("name") val name: String,
//        @SerializedName("picture") val picture: String,
//        @SerializedName("date") val date: String
//    )

    data class Person(
        @SerializedName("name") val name: String,
        @SerializedName("picture") val picture: String,
        @SerializedName("date") val date: String
    )
}