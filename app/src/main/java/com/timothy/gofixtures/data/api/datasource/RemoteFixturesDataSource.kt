package com.timothy.gofixtures.data.api.datasource

import com.timothy.gofixtures.data.api.model.apicompetition.ApiCompetition
import com.timothy.gofixtures.data.api.model.apimatches.ApiMatch
import com.timothy.gofixtures.util.Result

interface RemoteFixturesDataSource {

    suspend fun getCompetitions() : Result<List<ApiCompetition>>

    suspend fun getMatches(id:Int) : Result<List<ApiMatch>>
}