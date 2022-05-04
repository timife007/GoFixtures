package com.timothy.gofixtures.data.api.model.apimatches


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Penalties(
    @SerializedName("homeTeam")
    val homeTeam: Any?,
    @SerializedName("awayTeam")
    val awayTeam: Any?
) : Parcelable