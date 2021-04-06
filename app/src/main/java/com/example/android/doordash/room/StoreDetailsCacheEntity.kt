package com.example.android.doordash.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "store_details")
data class StoreDetailsCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name= "id")
    var id: Int,

    @ColumnInfo(name= "name")
    var name: String,

    @ColumnInfo(name= "description")
    var description: String,

    @ColumnInfo(name= "cover_img_url")
    var cover_img_url: String,

    @ColumnInfo(name= "delivery_fee")
    var delivery_fee: Int,

    @ColumnInfo(name= "average_rating")
    var average_rating: Float
)
