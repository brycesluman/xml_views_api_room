package com.example.android.doordash.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StoreCacheEntity::class], version = 2)
abstract class StoreDatabase: RoomDatabase() {
    abstract fun storeDao(): StoreDao

    companion object {
        val DATABASE_NAME: String = "store_db"
    }
}
