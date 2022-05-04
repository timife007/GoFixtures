package com.timothy.gofixtures.data.api.model.apimatches


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import kotlinx.parcelize.RawValue

@Parcelize
data class ApiGoal(
    @SerializedName("minute")
    val minute: Int,
    @SerializedName("type")
    val type:@RawValue Any?,
    @SerializedName("team")
    val team: Team,
    @SerializedName("scorer")
    val scorer: Scorer,
    @SerializedName("assist")
    val assist:@RawValue Any?
) : Parcelable