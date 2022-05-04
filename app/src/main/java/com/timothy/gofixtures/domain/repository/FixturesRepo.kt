package com.timothy.gofixtures.domain.repository

import com.timothy.gofixtures.domain.model.Competition
import com.timothy.gofixtures.domain.model.Match
import com.timothy.gofixtures.util.Result

interface FixturesRepo {
    suspend fun getCompetitions(refresh:Boolean): Result<List<Competition>>

    suspend fun getFixtures(id:Int):Result<List<Match>>

    suspend fun saveCompetition(competition:List<Competition>)

    suspend fun deleteCachedCompetition()
}