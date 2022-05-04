package com.timothy.gofixtures.data.cache.model.entities

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.RawValue

data class CacheCurrentSeason (
    val seasonId: Int,
    val startDate: String?,
    val endDate: String?,
    val currentMatchday: Any?
        )