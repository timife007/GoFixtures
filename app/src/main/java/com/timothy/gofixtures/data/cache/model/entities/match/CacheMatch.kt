package com.timothy.gofixtures.data.cache.model.entities.match

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import com.timothy.gofixtures.data.cache.model.entities.CacheCompetition

@Entity(
    tableName = "match_table",
    foreignKeys = [
        ForeignKey(
            entity = CacheCompetition::class,
            parentColumns = ["competitionId"],
            childColumns = ["competitionId"],
            onDelete = CASCADE
        )
    ],
    indices = [Index("competitionId")]
)
class CacheMatch(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "competitionId")
    val competitionId:Int,

    @Embedded
    val season: CacheSeason,
    @ColumnInfo(name = "utcDate")
    val utcDate: String,

    @ColumnInfo(name = "matchday")
    val matchday: Int,
    @ColumnInfo(name = "stage")
    val stage: String,

    @ColumnInfo(name = "group")
    val group: String,
    @Embedded
    val homeTeam: CacheHomeTeam,
    @Embedded
    val awayTeam: CacheAwayTeam,
    @Embedded
    val referee: CacheReferee
)