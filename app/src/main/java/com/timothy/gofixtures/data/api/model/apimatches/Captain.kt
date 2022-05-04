package com.timothy.gofixtures.data.api.model.apimatches


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Captain(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("shirtNumber")
    val shirtNumber: Int
) : Parcelable