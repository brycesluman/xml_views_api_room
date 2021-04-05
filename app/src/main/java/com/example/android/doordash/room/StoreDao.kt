package com.example.android.doordash.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(storeEntity: StoreCacheEntity): Long

    @Query("SELECT * FROM stores")
    suspend fun get(): List<StoreCacheEntity>
}