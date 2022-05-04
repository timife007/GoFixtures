package com.timothy.gofixtures.data.api.model.apicompetition


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import kotlinx.parcelize.RawValue

@Parcelize
data class ApiCurrentSeason(
    @SerializedName("id")
    val id: Int,
    @SerializedName("startDate")
    val startDate: String?,
    @SerializedName("endDate")
    val endDate: String?,
    @SerializedName("currentMatchday")
    val currentMatchday:@RawValue Any?
) : Parcelable