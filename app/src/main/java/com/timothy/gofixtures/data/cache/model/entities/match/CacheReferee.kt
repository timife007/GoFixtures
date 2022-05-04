package com.timothy.gofixtures.data.cache.model.entities.match

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.RawValue

data class CacheReferee (
    val id: Int,
    val name: String,
    val nationality:@RawValue Any?
)
