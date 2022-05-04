package com.timothy.gofixtures.data.api.model.apimatches


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ApiScore(
    @SerializedName("winner")
    val winner: String,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("fullTime")
    val fullTime: FullTime,
    @SerializedName("halfTime")
    val halfTime: HalfTime,
    @SerializedName("extraTime")
    val extraTime: ExtraTime,
    @SerializedName("penalties")
    val penalties: Penalties
) : Parcelable