package com.timothy.gofixtures.data.api.model.apicompetition


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ApiCompetitionResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("filters")
    val filters: ApiFilters,
    @SerializedName("competitions")
    val competitions: List<ApiCompetition>
) : Parcelable