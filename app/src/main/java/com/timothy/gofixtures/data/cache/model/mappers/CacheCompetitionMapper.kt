package com.timothy.gofixtures.data.cache.model.mappers

import com.timothy.gofixtures.data.cache.model.entities.CacheArea
import com.timothy.gofixtures.data.cache.model.entities.CacheCompetition
import com.timothy.gofixtures.data.cache.model.entities.CacheCurrentSeason
import com.timothy.gofixtures.domain.model.Area
import com.timothy.gofixtures.domain.model.Competition
import com.timothy.gofixtures.domain.model.CurrentSeason

class CacheCompetitionMapper:CacheMapper<List<Competition>,List<CacheCompetition>> {
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
            id = cacheCompetition.currentSeason.id,
            startDate = cacheCompetition.currentSeason.startDate,
            endDate = cacheCompetition.currentSeason.endDate,
            currentMatchday = cacheCompetition.currentSeason.currentMatchday
        )
    }

    private fun mapArea(cacheCompetition: CacheCompetition): Area {
        return Area(
            id = cacheCompetition.area.id,
            name = cacheCompetition.area.name
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
            id = competition.currentSeason.id,
            startDate = competition.currentSeason.startDate,
            endDate =  competition.currentSeason.endDate,
            currentMatchday = competition.currentSeason.currentMatchday
        )
    }

    private fun mapCacheArea(competition: Competition): CacheArea {
        return CacheArea(
            id = competition.area.id,
            name = competition.area.name
        )
    }
}