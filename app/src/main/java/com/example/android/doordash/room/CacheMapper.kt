package com.example.android.doordash.room

import com.example.android.doordash.model.Status
import com.example.android.doordash.model.Store
import com.example.android.doordash.retrofit.StatusNetworkEntity
import com.example.android.doordash.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor(): EntityMapper<StoreCacheEntity, Store> {
    override fun mapFromEntity(entity: StoreCacheEntity): Store {
        return Store(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            cover_img_url = entity.cover_img_url,
            open_time = entity.open_time,
            close_time = entity.close_time,
            unavailable_reason = entity.unavailable_reason,
            pickup_available = entity.pickup_available,
            asap_available = entity.asap_available,
            scheduled_available = entity.scheduled_available,
            asap_minutes = entity.asap_minutes,
            is_favorite = entity.is_favorite
        )
    }

    override fun mapToEntity(domainModel: Store): StoreCacheEntity {
        return StoreCacheEntity(
            id = domainModel.id,
            name = domainModel.name,
            description = domainModel.description,
            cover_img_url = domainModel.cover_img_url,
            open_time = domainModel.open_time,
            close_time = domainModel.close_time,
            unavailable_reason = domainModel.unavailable_reason,
            pickup_available = domainModel.pickup_available,
            asap_available = domainModel.asap_available,
            scheduled_available = domainModel.scheduled_available,
            asap_minutes = domainModel.asap_minutes,
            is_favorite = domainModel.is_favorite
        )
    }
    fun mapFromEntityList(entities: List<StoreCacheEntity>): List<Store> {
        return entities.map { mapFromEntity(it) }
    }
}