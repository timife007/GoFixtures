package com.timothy.gofixtures.data.cache.model.mappers

import com.timothy.gofixtures.data.cache.model.entities.CacheArea
import com.timothy.gofixtures.data.cache.model.entities.CacheCompetition
import com.timothy.gofixtures.data.cache.model.entities.CacheCurrentSeason
import com.timothy.gofixtures.domain.model.Area
import com.timothy.gofixtures.domain.model.Competition
import com.timothy.gofixtures.domain.model.CurrentSeason
import javax.inject.Inject

class CacheCompetitionMapper @Inject constructor():CacheMapper<List<Competition>,List<CacheCompetition>> {
    override fun mapToDomain(cacheModel: List<CacheCompetition>): List<Competition> {
        return cacheModel.map {
            Competition(
                id = it.competitionId,
                area = mapArea(it),
                name = it.name,
                code = it.code,
                currentSeason = mapCurrentSeason(it)
            )
        }
    }

    private fun mapCurrentSeason(cacheCompetition: CacheCompetition): CurrentSeason {
        return CurrentSeason(
            id = cacheCompetition.currentSeason.seasonId,
            startDate = cacheCompetition.currentSeason.startDate,
            endDate = cacheCompetition.currentSeason.endDate,
            currentMatchday = cacheCompetition.currentSeason.currentMatchday
        )
    }

    private fun mapArea(cacheCompetition: CacheCompetition): Area {
        return Area(
            id = cacheCompetition.area.areaId,
            name = cacheCompetition.area.areaName
        )
    }

    override fun mapFromDomain(domainModel: List<Competition>): List<CacheCompetition> {
        return domainModel.map {
            CacheCompetition(
                competitionId = it.id,
                area = mapCacheArea(it),
                name = it.name,
                code = it.code,
                currentSeason = mapCacheCurrentSeason(it)
            )
        }
    }

    private fun mapCacheCurrentSeason(competition: Competition): CacheCurrentSeason {
        return CacheCurrentSeason(
            seasonId = competition.currentSeason.id,
            startDate = competition.currentSeason.startDate,
            endDate =  competition.currentSeason.endDate,
            currentMatchday = competition.currentSeason.currentMatchday
        )
    }

    private fun mapCacheArea(competition: Competition): CacheArea {
        return CacheArea(
            areaId = competition.area.id,
            areaName = competition.area.name
        )
    }
}