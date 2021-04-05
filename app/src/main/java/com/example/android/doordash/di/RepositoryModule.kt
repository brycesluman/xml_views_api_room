package com.example.android.doordash.di

import com.example.android.doordash.retrofit.NetworkMapper
import com.example.android.doordash.room.StoreDao
import com.example.android.doordash.room.CacheMapper
import com.example.android.doordash.repository.MainRepository
import com.example.android.doordash.retrofit.StoreRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMainRepository(
        storeDao: StoreDao,
        retrofit: StoreRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(storeDao, retrofit, cacheMapper, networkMapper)
    }
}