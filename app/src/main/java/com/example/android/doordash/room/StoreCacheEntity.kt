package com.example.android.doordash.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.doordash.model.Status

//store_feed
@Entity(tableName = "stores")
data class StoreCacheEntity (

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name= "id")
    var id: Int,

    @ColumnInfo(name= "name")
    var name: String,

    @ColumnInfo(name= "description")
    var description: String,

    @ColumnInfo(name= "cover_img_url")
    var cover_img_url: String,

    @ColumnInfo(name= "open_time")
    var open_time: String,

    @ColumnInfo(name= "close_time")
    var close_time: String,

    @ColumnInfo(name="unavailable_reason")
    var unavailable_reason: String?,

    @ColumnInfo(name="pickup_available")
    var pickup_available: Boolean,

    @ColumnInfo(name="asap_available")
    var asap_available: Boolean,

    @ColumnInfo(name="scheduled_available")
    var scheduled_available: Boolean,

    @ColumnInfo(name="asap_minutes")
    var asap_minutes: Int,

    @ColumnInfo(name="is_favorite")
    var is_favorite: Boolean
)