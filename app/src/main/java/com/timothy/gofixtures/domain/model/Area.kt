package com.timothy.gofixtures.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Area(
    val id: Int,
    val name: String
):Parcelable