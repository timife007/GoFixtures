package com.timothy.gofixtures.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class CurrentSeason(
    val id: Int,
    val startDate: String?,
    val endDate: String?,
    val currentMatchday:@RawValue Any?
):Parcelable
