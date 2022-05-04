package com.timothy.gofixtures.domain.model

import android.os.Parcelable
import com.timothy.gofixtures.data.api.model.apimatches.*
import kotlinx.parcelize.Parcelize

@Parcelize
data class Match(
    val id: Int,
    val season: Season,
    val utcDate: String,
    val matchday: Int,
    val stage: String,
    val group: String,
    val homeTeam: HomeTeam,
    val awayTeam: AwayTeam,
    val referee: Referee
) : Parcelable
