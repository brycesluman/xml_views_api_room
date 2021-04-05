package com.example.android.doordash.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

interface StoreRetrofit {
    //    store_feed
    @GET("v1/store_feed")
    suspend fun get(
        @Query("lat") lat: String,
        @Query("lng") lng: String,
        @Query("offset") offset: String,
        @Query("limit") limit: String
    ): StoreFeedNetworkEntity
}