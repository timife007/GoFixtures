package com.timothy.gofixtures.data.api.model.apimatches


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ApiMatch(
    @SerializedName("id")
    val id: Int,
    @SerializedName("season")
    val apiSeason: ApiSeason,
    @SerializedName("utcDate")
    val utcDate: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("attendance")
    val attendance: Int,
    @SerializedName("matchday")
    val matchday: Int,
    @SerializedName("stage")
    val stage: String,
    @SerializedName("group")
    val group: String,
    @SerializedName("lastUpdated")
    val lastUpdated: String,
    @SerializedName("homeTeam")
    val homeTeam: ApiHomeTeam,
    @SerializedName("awayTeam")
    val awayTeam: ApiAwayTeam,
    @SerializedName("score")
    val score: ApiScore,
    @SerializedName("goals")
    val goals: List<ApiGoal>,
    @SerializedName("bookings")
    val bookings: List<Booking>,
    @SerializedName("substitutions")
    val substitutions: List<Substitution>,
    @SerializedName("referees")
    val referees: List<ApiReferee>
) : Parcelable