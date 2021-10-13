package com.imtatlantique.kotlin_project.repository

import com.imtatlantique.kotlin_project.domain.model.Book

interface IBookRepository {
    suspend fun query_api(): List<Book>
}