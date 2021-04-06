package com.example.android.doordash.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StoreDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(storeEntity: StoreDetailsCacheEntity): Long

    @Query("SELECT * FROM store_details WHERE id=:id")
    suspend fun get(id: Int): StoreDetailsCacheEntity
}