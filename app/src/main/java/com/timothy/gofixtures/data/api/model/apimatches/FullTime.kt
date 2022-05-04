package com.timothy.gofixtures.data.api.model.apimatches


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class FullTime(
    @SerializedName("homeTeam")
    val homeTeam: Int,
    @SerializedName("awayTeam")
    val awayTeam: Int
) : Parcelable