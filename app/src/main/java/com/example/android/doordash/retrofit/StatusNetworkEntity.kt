package com.example.android.doordash.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class StatusNetworkEntity(
    @SerializedName("unavailable_reason")
    @Expose
    var unavailable_reason: String?,

    @SerializedName("pickup_available")
    @Expose
    var pickup_available: Boolean,

    @SerializedName("asap_available")
    @Expose
    var asap_available: Boolean,

    @SerializedName("scheduled_available")
    @Expose
    var scheduled_available: Boolean,

    @SerializedName("asap_minutes_range")
    @Expose
    var asap_minutes_range: List<Int>
)
