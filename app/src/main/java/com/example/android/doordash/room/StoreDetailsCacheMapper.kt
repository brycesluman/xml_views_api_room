package com.example.android.doordash.room

import com.example.android.doordash.model.StoreDetails
import com.example.android.doordash.util.EntityMapper
import javax.inject.Inject

class StoreDetailsCacheMapper
@Inject
constructor() : EntityMapper<StoreDetailsCacheEntity, StoreDetails> {
    override fun mapFromEntity(entity: StoreDetailsCacheEntity): StoreDetails {
        return StoreDetails(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            cover_img_url = entity.cover_img_url,
            delivery_fee = entity.delivery_fee,
            average_rating = entity.average_rating
        )
    }

    override fun mapToEntity(domainModel: StoreDetails): StoreDetailsCacheEntity {
        return StoreDetailsCacheEntity(
            id = domainModel.id,
            name = domainModel.name,
            description = domainModel.description,
            cover_img_url = domainModel.cover_img_url,
            delivery_fee = domainModel.delivery_fee,
            average_rating = domainModel.average_rating
        )
    }
}