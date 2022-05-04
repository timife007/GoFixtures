package com.timothy.gofixtures.data.api.model.apimatches


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Substitution(
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("team")
    val team: TeamXX,
    @SerializedName("playerOut")
    val playerOut: PlayerOut,
    @SerializedName("playerIn")
    val playerIn: PlayerIn
) : Parcelable