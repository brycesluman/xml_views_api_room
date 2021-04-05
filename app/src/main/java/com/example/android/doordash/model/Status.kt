package com.example.android.doordash.model

data class Status(
    val storeId: Int,
    val unavailable_reason: String,
    val pickup_available: Boolean,
    val asap_available: Boolean,
    val scheduled_available: Boolean,
    val asap_minutes_range: Int
)
