package com.timothy.gofixtures.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.timothy.gofixtures.data.api.model.apicompetition.ApiArea
import com.timothy.gofixtures.data.api.model.apicompetition.ApiCurrentSeason
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Competition(
    val id : Int,
    val area: Area,
    val name: String,
    val code:@RawValue Any?,
    val currentSeason: CurrentSeason,
):Parcelable
