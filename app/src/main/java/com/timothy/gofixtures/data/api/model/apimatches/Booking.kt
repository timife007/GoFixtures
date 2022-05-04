package com.timothy.gofixtures.data.api.model.apimatches


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Booking(
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("team")
    val team: TeamX,
    @SerializedName("player")
    val player: Player,
    @SerializedName("card")
    val card: String
) : Parcelable