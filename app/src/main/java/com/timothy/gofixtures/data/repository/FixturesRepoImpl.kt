package com.timothy.gofixtures.data.repository

import com.timothy.gofixtures.data.api.datasource.RemoteFixturesDataSource
import com.timothy.gofixtures.data.api.model.mappers.ApiCompetitionMapper
import com.timothy.gofixtures.data.api.model.mappers.ApiMatchesMapper
import com.timothy.gofixtures.data.cache.datasource.LocalFixturesDataSource
import com.timothy.gofixtures.data.cache.model.mappers.CacheCompetitionMapper
import com.timothy.gofixtures.di.qualifiers.IoDispatcher
import com.timothy.gofixtures.domain.model.Competition
import com.timothy.gofixtures.domain.model.Match
import com.timothy.gofixtures.domain.repository.FixturesRepo
import com.timothy.gofixtures.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FixturesRepoImpl @Inject constructor(
    private val remoteFixturesDataSource: RemoteFixturesDataSource,
    private val localFixturesDataSource: LocalFixturesDataSource,
    private val apiMatchesMapper: ApiMatchesMapper,
    private val apiCompetitionMapper: ApiCompetitionMapper,
    private val localCompetitionMapper: CacheCompetitionMapper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : FixturesRepo {
    override suspend fun getCompetitions(refresh: Boolean): Result<List<Competition>> =
        withContext(ioDispatcher) {
            if (refresh) {
                when (val response = remoteFixturesDataSource.getCompetitions()) {
                    is Result.Success -> {
                        if (response.data != null) {
                            Result.Success(apiCompetitionMapper.mapToDomain(response.data))
                        } else {
                            Result.Success(null)
                        }
                    }

                    is Result.Error -> {
                        Result.Error(response.exception)
                    }

                    else -> Result.Loading
                }
            } else {
                val competition = localFixturesDataSource.getCompetition()
                if (competition != null) {
                    Result.Success(localCompetitionMapper.mapToDomain(competition))
                } else {
                    Result.Success(null)
                }
            }
        }

    override suspend fun getFixtures(id: Int): Result<List<Match>> = withContext(ioDispatcher) {
        when (val response = remoteFixturesDataSource.getMatches(id)) {
            is Result.Success -> {
                if (response.data != null) {
                    Result.Success(apiMatchesMapper.mapToDomain(response.data))
                } else {
                    Result.Success(null)
                }
            }
            is Result.Error -> {
                Result.Error(response.exception)
            }
            else -> Result.Loading
        }
    }

    override suspend fun saveCompetition(competition: List<Competition>) {
        withContext(ioDispatcher) {
            localCompetitionMapper.mapFromDomain(competition).let { cachedList ->
                cachedList.forEach {
                    localFixturesDataSource.insertCompetition(it)
                }
            }
        }
    }

    override suspend fun deleteCachedCompetition() {
        withContext(ioDispatcher) {
            localFixturesDataSource.deleteCompetition()
        }
    }
}