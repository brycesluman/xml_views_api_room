package com.example.android.doordash.repository

import com.example.android.doordash.model.StoreDetails
import com.example.android.doordash.retrofit.StoreDetailsNetworkMapper
import com.example.android.doordash.retrofit.StoreDetailsRetrofit
import com.example.android.doordash.room.StoreDetailsCacheMapper
import com.example.android.doordash.room.StoreDetailsDao
import com.example.android.doordash.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DetailsRepository
constructor(
    private val storeDetailsDao: StoreDetailsDao,
    private val storeDetailsRetrofit: StoreDetailsRetrofit,
    private val storeDetailsCacheMapper: StoreDetailsCacheMapper,
    private val storeDetailsNetworkMapper: StoreDetailsNetworkMapper
){
    suspend fun getStoreDetails(id: Int): Flow<DataState<StoreDetails>> = flow{
        emit(DataState.Loading)
        try{
            val networkStore = storeDetailsRetrofit.get(id)
            val store = storeDetailsNetworkMapper.mapFromEntity(networkStore)
            storeDetailsDao.insert(storeDetailsCacheMapper.mapToEntity(store))
            val cachedStore = storeDetailsDao.get(id)
            emit(DataState.Success(storeDetailsCacheMapper.mapFromEntity(cachedStore)))

        } catch(e: Exception) {
            emit(DataState.Error(e))
        }
    }
}