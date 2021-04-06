package com.example.android.doordash.di

import com.example.android.doordash.repository.DetailsRepository
import com.example.android.doordash.retrofit.NetworkMapper
import com.example.android.doordash.room.StoreDao
import com.example.android.doordash.room.CacheMapper
import com.example.android.doordash.repository.MainRepository
import com.example.android.doordash.retrofit.StoreDetailsNetworkMapper
import com.example.android.doordash.retrofit.StoreDetailsRetrofit
import com.example.android.doordash.retrofit.StoreRetrofit
import com.example.android.doordash.room.StoreDetailsCacheMapper
import com.example.android.doordash.room.StoreDetailsDao
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

    @Singleton
    @Provides
    fun provideDetailsRepository(
        storeDetailsDao: StoreDetailsDao,
        detailsRetrofit: StoreDetailsRetrofit,
        storeDetailsCacheMapper: StoreDetailsCacheMapper,
        storeDetailsNetworkMapper: StoreDetailsNetworkMapper
    ): DetailsRepository {
        return DetailsRepository(storeDetailsDao, detailsRetrofit, storeDetailsCacheMapper, storeDetailsNetworkMapper)
    }
}