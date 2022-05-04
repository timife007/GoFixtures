package com.timothy.gofixtures.data.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.timothy.gofixtures.data.cache.model.entities.CacheCompetition
@Dao
interface FixturesDao {
    @Query("SELECT * FROM competition_table")
    suspend fun getAllCompetitions(): List<CacheCompetition>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompetition(cacheCompetition: CacheCompetition)

    @Query("DELETE FROM competition_table")
    suspend fun deleteCacheCompetition()
}
