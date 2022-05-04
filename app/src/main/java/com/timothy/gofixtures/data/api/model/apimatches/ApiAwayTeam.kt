package com.timothy.gofixtures.data.api.model.apimatches


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ApiAwayTeam(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("coach")
    val coach: CoachX,
    @SerializedName("captain")
    val captain: CaptainX,
    @SerializedName("lineup")
    val lineup: List<LineupX>,
    @SerializedName("bench")
    val bench: List<BenchX>
) : Parcelable