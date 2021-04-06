package com.example.android.doordash.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class StoreDetailsNetworkEntity (
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("description")
    @Expose
    var description: String,

    @SerializedName("cover_img_url")
    @Expose
    var cover_img_url: String,

    @SerializedName("delivery_fee")
    @Expose
    var delivery_fee: Int,

    @SerializedName("average_rating")
    @Expose
    var average_rating: Float
)