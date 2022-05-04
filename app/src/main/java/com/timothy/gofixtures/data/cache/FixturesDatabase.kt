package com.timothy.gofixtures.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.timothy.gofixtures.data.cache.daos.FixturesDao
import com.timothy.gofixtures.data.cache.model.TypeConverters
import com.timothy.gofixtures.data.cache.model.entities.CacheCompetition

@Database(
    entities = [CacheCompetition::class],
    version = 1,
    exportSchema = false,
//    autoMigrations = [
//        AutoMigration (from = 1, to = 2)
//    ]
)
@androidx.room.TypeConverters(TypeConverters::class)
abstract class FixturesDatabase: RoomDatabase() {
    abstract fun fixturesDao(): FixturesDao
}