package com.timothy.gofixtures.data.api.model.apimatches


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ApiHomeTeam(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("coach")
    val coach: Coach,
    @SerializedName("captain")
    val captain: Captain,
    @SerializedName("lineup")
    val lineup: List<Lineup>,
    @SerializedName("bench")
    val bench: List<Bench>
) : Parcelable