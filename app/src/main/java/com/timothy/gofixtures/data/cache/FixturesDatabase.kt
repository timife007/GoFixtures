package com.timothy.gofixtures.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.timothy.gofixtures.data.cache.daos.FixturesDao

@Database(
    entities = [],
    version = 1,
    exportSchema = true,
//    autoMigrations = [
//        AutoMigration (from = 1, to = 2)
//    ]
)
abstract class FixturesDatabase: RoomDatabase() {
    abstract fun fixturesDao(): FixturesDao
}