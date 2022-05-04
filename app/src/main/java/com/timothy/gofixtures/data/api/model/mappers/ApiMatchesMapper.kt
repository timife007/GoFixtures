package com.timothy.gofixtures.data.api.model.mappers

import com.timothy.gofixtures.data.api.model.apimatches.ApiMatch
import com.timothy.gofixtures.data.api.model.apimatches.ApiSeason
import com.timothy.gofixtures.domain.model.*
import javax.inject.Inject

class ApiMatchesMapper @Inject constructor():ApiMapper<List<ApiMatch>,List<Match>> {
    override fun mapToDomain(apiModel: List<ApiMatch>): List<Match> {
        return apiModel.map {
            Match(
                id = it.id,
                season = mapSeason(it),
                utcDate = it.utcDate,
                matchday = it.matchday,
                stage = it.stage,
                group = it.group,
                homeTeam = mapHomeTeam(it),
                awayTeam = mapAwayTeam(it),
                referee = mapReferee(it)
            )
        }
    }

    private fun mapReferee(apiMatch: ApiMatch): Referee {
        return Referee(
            id = apiMatch.referees[0].id,
            name = apiMatch.referees[0].name
        )
    }

    private fun mapAwayTeam(apiMatch: ApiMatch): AwayTeam {
        return AwayTeam(
            id = apiMatch.awayTeam.id,
            name = apiMatch.awayTeam.name
        )
    }

    private fun mapHomeTeam(apiMatch: ApiMatch): HomeTeam {
        return HomeTeam(
            id = apiMatch.homeTeam.id,
            name = apiMatch.homeTeam.name
        )
    }

    private fun mapSeason(apiMatch: ApiMatch): Season {
        return Season(
            id = apiMatch.apiSeason.id,
            startDate = apiMatch.apiSeason.startDate,
            endDate = apiMatch.apiSeason.endDate,
            currentMatchday = apiMatch.apiSeason.currentMatchday
        )
    }
}