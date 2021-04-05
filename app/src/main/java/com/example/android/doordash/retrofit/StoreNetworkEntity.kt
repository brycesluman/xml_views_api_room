package com.example.android.doordash.retrofit

import com.example.android.doordash.model.Status
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class StoreNetworkEntity(
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

    @SerializedName("next_open_time")
    @Expose
    var open_time: String,

    @SerializedName("next_close_time")
    @Expose
    var close_time: String,

    @SerializedName("status")
    @Expose
    var status: StatusNetworkEntity
)
