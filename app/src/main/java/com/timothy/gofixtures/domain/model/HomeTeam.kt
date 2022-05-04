package com.timothy.gofixtures.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.timothy.gofixtures.data.api.model.apimatches.Coach
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeTeam(
    val id: Int,
    val name: String
):Parcelable