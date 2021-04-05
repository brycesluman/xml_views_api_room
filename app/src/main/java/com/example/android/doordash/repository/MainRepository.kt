package com.example.android.doordash.repository

import com.example.android.doordash.retrofit.NetworkMapper
import com.example.android.doordash.room.StoreDao
import com.example.android.doordash.room.CacheMapper
import com.example.android.doordash.util.DataState
import com.example.android.doordash.model.Store
import com.example.android.doordash.retrofit.StoreRetrofit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
    private val storeDao: StoreDao,
    private val storeRetrofit: StoreRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
){
    suspend fun getStore(): Flow<DataState<List<Store>>> = flow{
        emit(DataState.Loading)
        try{
            val networkStores = storeRetrofit.get("37.422740",
                "-122.139956", "0", "50")
            val stores = networkMapper.mapFromEntityList(networkStores.stores)
            for(store in stores) {
                storeDao.insert(cacheMapper.mapToEntity(store))
            }
            val cachedStores = storeDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedStores)))

        } catch(e: Exception) {
            emit(DataState.Error(e))
        }
    }
}