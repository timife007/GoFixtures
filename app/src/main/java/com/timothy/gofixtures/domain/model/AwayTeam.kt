package com.timothy.gofixtures.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.timothy.gofixtures.data.api.model.apimatches.CoachX
import kotlinx.parcelize.Parcelize

@Parcelize
data class AwayTeam(
    val id: Int,
    val name: String,
):Parcelable