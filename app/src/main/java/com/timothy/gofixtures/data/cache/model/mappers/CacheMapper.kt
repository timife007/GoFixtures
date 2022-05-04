package com.timothy.gofixtures.data.cache.model.mappers

interface CacheMapper<D,C> {
    fun mapToDomain(cacheModel:C):D
    fun mapFromDomain(domainModel:D):C
}