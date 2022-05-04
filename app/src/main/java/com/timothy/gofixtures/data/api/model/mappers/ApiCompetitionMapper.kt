package com.timothy.gofixtures.data.api.model.mappers

import com.timothy.gofixtures.data.api.model.apicompetition.ApiCompetition
import com.timothy.gofixtures.domain.model.Area
import com.timothy.gofixtures.domain.model.Competition
import com.timothy.gofixtures.domain.model.CurrentSeason

class ApiCompetitionMapper(private val apiMatchesMapper: ApiMatchesMapper) : ApiMapper<List<ApiCompetition>,List<Competition>>{
    override fun mapToDomain(apiModel: List<ApiCompetition>): List<Competition> {
        return apiModel.map {
            Competition(
                id = it.id,
                area = mapArea(it),
                name = it.name,
                code = it.code,
                currentSeason = mapCurrentSeason(it)
            )
        }
    }

    private fun mapCurrentSeason(apiCompetition: ApiCompetition): CurrentSeason {
        return CurrentSeason(
            id = apiCompetition.currentSeason!!.id,
            startDate = apiCompetition.currentSeason.startDate,
            endDate = apiCompetition.currentSeason.endDate,
            currentMatchday = apiCompetition.currentSeason.currentMatchday
        )
    }

    private fun mapArea(apiCompetition: ApiCompetition): Area {
        return Area(
            apiCompetition.area.id,
            apiCompetition.area.name
        )
    }
}