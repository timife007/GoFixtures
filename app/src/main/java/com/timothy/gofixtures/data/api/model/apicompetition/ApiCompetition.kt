package com.timothy.gofixtures.data.api.model.apicompetition


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import kotlinx.parcelize.RawValue

@Parcelize
data class ApiCompetition(
    @SerializedName("id")
    val id: Int,
    @SerializedName("area")
    val area: ApiArea,
    @SerializedName("name")
    val name: String,
    @SerializedName("code")
    val code:@RawValue Any?,
    @SerializedName("plan")
    val plan: String,
    @SerializedName("currentSeason")
    val currentSeason: ApiCurrentSeason?,
    @SerializedName("numberOfAvailableSeasons")
    val numberOfAvailableSeasons: Int,
    @SerializedName("lastUpdated")
    val lastUpdated: String
) : Parcelable