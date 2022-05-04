package com.timothy.gofixtures.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Season(
    val id: Int,
    val startDate: String,
    val endDate: String,
    val currentMatchday: Int
):Parcelable