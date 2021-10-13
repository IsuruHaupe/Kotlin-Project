package com.imtatlantique.kotlin_project.network.model

import com.imtatlantique.kotlin_project.domain.model.Book
import com.imtatlantique.kotlin_project.domain.util.DomainMapperInterface

class BookDtoMapper : DomainMapperInterface<BookDto, Book>{
    override fun mapToDomainModel(model: BookDto): Book {
        return Book(
            isbn = model.isbn,
            title = model.title,
            cover = model.cover,
            price = model.price,
            synopsis = model.synopsis
        )
    }

    fun toDomainList(from : List<BookDto>) : List<Book> {
        return from.map { mapToDomainModel(it) }
    }
}