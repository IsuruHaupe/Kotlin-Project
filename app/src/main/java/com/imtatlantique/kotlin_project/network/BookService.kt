package com.imtatlantique.kotlin_project.network

import com.imtatlantique.kotlin_project.network.model.BookDto
import retrofit2.http.GET

interface BookService {
    @GET("books")
    suspend fun query() : List<BookDto>
}