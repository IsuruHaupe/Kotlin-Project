package com.imtatlantique.kotlin_project.repository

import com.imtatlantique.kotlin_project.domain.model.Book
import com.imtatlantique.kotlin_project.network.BookService
import com.imtatlantique.kotlin_project.network.model.BookDtoMapper

class BookRepository(
    private val bookService : BookService,
    private val mapper : BookDtoMapper
) : IBookRepository {
    override suspend fun query_api(): List<Book> {
        return mapper.toDomainList(bookService.query())
    }
}