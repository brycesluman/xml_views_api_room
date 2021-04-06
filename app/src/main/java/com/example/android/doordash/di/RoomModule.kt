package com.example.android.doordash.di

import android.content.Context
import androidx.room.Room
import com.example.android.doordash.room.StoreDao
import com.example.android.doordash.room.StoreDatabase
import com.example.android.doordash.room.StoreDetailsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext

import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideStoreDb(@ApplicationContext context: Context): StoreDatabase {
        return Room.databaseBuilder(
            context,
            StoreDatabase::class.java,
            StoreDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideStoreDAO(storeDatabase: StoreDatabase): StoreDao {
        return storeDatabase.storeDao()
    }

    @Singleton
    @Provides
    fun provideStoreDetailsDAO(storeDatabase: StoreDatabase): StoreDetailsDao {
        return storeDatabase.storeDetailsDao()
    }
}