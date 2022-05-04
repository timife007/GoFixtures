package com.timothy.gofixtures.data.api

import com.timothy.gofixtures.data.api.model.apicompetition.ApiCompetitionResponse
import com.timothy.gofixtures.data.api.model.apimatches.ApiMatchesResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoFixturesApi {

    @GET(ApiConstants.COMPETITIONS_ENDPOINT)
    suspend fun getCompetitions(): Response<ApiCompetitionResponse>

    @GET(ApiConstants.FIXTURES_ENDPOINT)
    suspend fun getMatches(@Path("id") id : Int):Response<ApiMatchesResponse>
}