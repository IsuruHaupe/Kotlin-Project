package com.imtatlantique.kotlin_project.dependency_injection

import com.google.gson.GsonBuilder
import com.imtatlantique.kotlin_project.network.BookService
import com.imtatlantique.kotlin_project.network.model.BookDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideBookMapper(): BookDtoMapper{
        return BookDtoMapper()
    }

    @Singleton
    @Provides
    fun provideBookService(): BookService{
        return Retrofit.Builder()
            .baseUrl("https://henri-potier.techx.fr/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(BookService::class.java)
    }
}