package com.timothy.gofixtures.data.cache.datasource

import com.timothy.gofixtures.data.cache.daos.FixturesDao
import com.timothy.gofixtures.data.cache.model.entities.CacheCompetition
import com.timothy.gofixtures.di.qualifiers.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalFixturesDataSourceImpl @Inject constructor(
private val fixturesDao: FixturesDao,
@IoDispatcher private val ioDispatcher:CoroutineDispatcher
) : LocalFixturesDataSource {
    override suspend fun getCompetition(): List<CacheCompetition> = withContext(ioDispatcher){
        return@withContext fixturesDao.getAllCompetitions()
    }

    override suspend fun insertCompetition(competition: CacheCompetition)= withContext(ioDispatcher){
        return@withContext fixturesDao.insertCompetition(competition)
    }

    override suspend fun deleteCompetition()= withContext(ioDispatcher){
        return@withContext fixturesDao.deleteCacheCompetition()
    }
}