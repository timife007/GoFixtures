package com.timothy.gofixtures.data.api.model.apimatches


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Competition(
    @SerializedName("id")
    val id: Int,
    @SerializedName("area")
    val area: Area,
    @SerializedName("name")
    val name: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("plan")
    val plan: String,
    @SerializedName("lastUpdated")
    val lastUpdated: String
) : Parcelable