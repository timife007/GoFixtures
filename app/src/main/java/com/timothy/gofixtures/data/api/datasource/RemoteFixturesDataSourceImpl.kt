package com.timothy.gofixtures.data.api.datasource

import com.timothy.gofixtures.data.api.GoFixturesApi
import com.timothy.gofixtures.data.api.model.apicompetition.ApiCompetition
import com.timothy.gofixtures.data.api.model.apimatches.ApiMatch
import com.timothy.gofixtures.di.qualifiers.IoDispatcher
import com.timothy.gofixtures.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteFixturesDataSourceImpl @Inject constructor(
    private val api: GoFixturesApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher

) : RemoteFixturesDataSource {
    override suspend fun getCompetitions(): Result<List<ApiCompetition>> = withContext(ioDispatcher){
        return@withContext try{
            val result = api.getCompetitions()
            if (result.isSuccessful){
                val competition = result.body()?.competitions
                Result.Success(competition)
            }else{
                Result.Success(null)
            }
        }catch (exception:Exception){
            Result.Error(exception)
        }
    }

    override suspend fun getMatches(id: Int): Result<List<ApiMatch>> = withContext(ioDispatcher){
        return@withContext try{
            val result = api.getMatches(id)
            if (result.isSuccessful){
                val matches = result.body()?.matches
                Result.Success(matches)
            }else{
                Result.Success(null)
            }
        }catch (exception:Exception){
            Result.Error(exception)
        }
    }
}