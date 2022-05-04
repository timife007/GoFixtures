package com.timothy.gofixtures.data.cache.model.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.timothy.gofixtures.domain.model.Area
import com.timothy.gofixtures.domain.model.CurrentSeason
import kotlinx.parcelize.RawValue

@Entity(tableName = "competition_table")
data class CacheCompetition(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val competitionId: Int,

    @Embedded
    val area: CacheArea,
    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "code")
    val code: @RawValue Any?,

    @Embedded
    val currentSeason: CacheCurrentSeason
)