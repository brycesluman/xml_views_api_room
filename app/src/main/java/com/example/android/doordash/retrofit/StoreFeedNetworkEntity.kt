package com.example.android.doordash.retrofit

import com.example.android.doordash.model.Store
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class StoreFeedNetworkEntity(
    @SerializedName("stores")
    @Expose
    var stores: List<StoreNetworkEntity>
)
