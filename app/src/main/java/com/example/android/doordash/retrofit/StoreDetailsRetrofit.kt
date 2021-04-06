package com.example.android.doordash.retrofit

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StoreDetailsRetrofit {
    //    /v2/restaurant/
    @GET("/v2/restaurant/{id}")
    suspend fun get(
        @Path("id") id: Int
    ): StoreDetailsNetworkEntity
}