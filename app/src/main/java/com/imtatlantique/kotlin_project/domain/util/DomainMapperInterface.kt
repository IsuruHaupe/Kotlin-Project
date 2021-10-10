package com.imtatlantique.kotlin_project.domain.util

interface DomainMapperInterface<T, DomainModel>{
    // to convert network entity to domain model
    fun mapToDomainModel(model: T): DomainModel
}