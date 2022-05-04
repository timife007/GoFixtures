package com.timothy.gofixtures.di

import android.content.Context
import androidx.room.Room
import com.timothy.gofixtures.data.cache.daos.FixturesDao
import com.timothy.gofixtures.data.cache.FixturesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CacheModule {
    companion object{
        @Provides
        @Singleton
        fun provideDatabase(
            @ApplicationContext context:Context
        ):FixturesDatabase{
            return Room.databaseBuilder(
                context,
                FixturesDatabase::class.java,
                "fixtures_database"
            ).build()
        }

        @Provides
        fun provideCatsDao(
            fixturesDatabase: FixturesDatabase
        ): FixturesDao {
            return fixturesDatabase.fixturesDao()
        }
    }
}