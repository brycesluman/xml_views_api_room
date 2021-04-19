package com.example.android.doordash.room

import androidx.room.*

@Dao
interface StoreDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(storeEntity: StoreCacheEntity): Long

    @Query("SELECT * FROM stores")
    suspend fun get(): List<StoreCacheEntity>

    @Update
    suspend fun update(storeEntity: StoreCacheEntity)
}