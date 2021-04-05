package com.example.android.doordash.model

data class Store(
    var id: Int,
    var name: String,
    var description: String,
    var cover_img_url: String,
    var open_time: String,
    var close_time: String,
    val unavailable_reason: String?,
    val pickup_available: Boolean,
    val asap_available: Boolean,
    val scheduled_available: Boolean,
    val asap_minutes: Int
)