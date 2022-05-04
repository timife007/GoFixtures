package com.timothy.gofixtures.data.api.model.mappers

interface ApiMapper<A,D> {
    fun mapToDomain(apiModel:A):D
}