package com.example.android.doordash.retrofit
import com.example.android.doordash.model.Store
import com.example.android.doordash.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
    @Inject
    constructor() : EntityMapper<StoreNetworkEntity, Store> {
    override fun mapFromEntity(entity: StoreNetworkEntity): Store {
        return Store(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            cover_img_url = entity.cover_img_url,
            open_time = entity.open_time,
            close_time = entity.close_time,
            unavailable_reason = entity.status.unavailable_reason,
            pickup_available = entity.status.pickup_available,
            asap_available = entity.status.asap_available,
            scheduled_available = entity.status.scheduled_available,
            asap_minutes = entity.status.asap_minutes_range[0],
            is_favorite = false
        )
    }

    override fun mapToEntity(domainModel: Store): StoreNetworkEntity {
        return StoreNetworkEntity(
            id = domainModel.id,
            name = domainModel.name,
            description = domainModel.description,
            cover_img_url = domainModel.cover_img_url,
            open_time = domainModel.open_time,
            close_time = domainModel.close_time,
            status = StatusNetworkEntity(
                domainModel.unavailable_reason,
                domainModel.pickup_available,
                domainModel.asap_available,
                domainModel.scheduled_available,
                listOf(domainModel.asap_minutes)
            )
        )
    }

    fun mapFromEntityList(entities: List<StoreNetworkEntity>): List<Store> {
        return entities.map { mapFromEntity(it) }
    }
}