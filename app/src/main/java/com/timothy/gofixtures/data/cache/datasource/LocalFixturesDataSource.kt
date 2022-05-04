package com.timothy.gofixtures.data.cache.datasource

import com.timothy.gofixtures.data.cache.model.entities.CacheCompetition

interface LocalFixturesDataSource {
    suspend fun getCompetition(): List<CacheCompetition>?
    suspend fun insertCompetition(competition: CacheCompetition)
    suspend fun deleteCompetition()
}