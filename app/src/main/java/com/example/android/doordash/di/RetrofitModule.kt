package com.example.android.doordash.di

import com.example.android.doordash.retrofit.StoreDetailsRetrofit
import com.example.android.doordash.retrofit.StoreRetrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
//@InstallIn(ApplicationComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson{
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }
//https://api.doordash.com/v1/store_feed/?lat=37.422740&lng=-122.139956&offset=0&limit=50
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://api.doordash.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideStoreService(retrofit: Retrofit.Builder): StoreRetrofit {
        return retrofit
            .build()
            .create(StoreRetrofit::class.java)
    }

    @Singleton
    @Provides
    fun provideStoreDetailsService(retrofit: Retrofit.Builder): StoreDetailsRetrofit {
        return retrofit
            .build()
            .create(StoreDetailsRetrofit::class.java)
    }
}