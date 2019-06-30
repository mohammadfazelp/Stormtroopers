package com.faz.data.remote.api

import com.faz.data.remote.model.TripEntity
import io.reactivex.Single
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface TripApi {

    @Headers("Content-Type: application/json")
    @GET("trips")
    fun getTrips(): Single<List<TripEntity.Trip>>

    @GET("trips/{tripId}")
    fun getTripById(@Path("tripId") id : Long) : Single<TripEntity.Trip>
}