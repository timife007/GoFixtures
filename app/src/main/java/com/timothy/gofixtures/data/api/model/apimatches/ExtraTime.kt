package com.timothy.gofixtures.data.api.model.apimatches


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import kotlinx.parcelize.RawValue

@Parcelize
data class ExtraTime(
    @SerializedName("homeTeam")
    val homeTeam:@RawValue Any?,
    @SerializedName("awayTeam")
    val awayTeam:@RawValue Any?
) : Parcelable