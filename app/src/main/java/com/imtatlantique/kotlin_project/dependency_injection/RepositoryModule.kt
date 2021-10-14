package com.imtatlantique.kotlin_project.dependency_injection

import com.imtatlantique.kotlin_project.network.BookService
import com.imtatlantique.kotlin_project.network.model.BookDtoMapper
import com.imtatlantique.kotlin_project.repository.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideBookRepository(
        bookService : BookService,
        bookDtoMapper: BookDtoMapper
    ): BookRepository{
        return BookRepository(bookService = bookService, mapper = bookDtoMapper)
    }
}