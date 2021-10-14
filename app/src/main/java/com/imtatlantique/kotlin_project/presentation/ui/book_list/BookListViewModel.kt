package com.imtatlantique.kotlin_project.presentation.ui.book_list

import androidx.lifecycle.ViewModel
import com.imtatlantique.kotlin_project.dependency_injection.RepositoryModule
import com.imtatlantique.kotlin_project.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookListViewModel
@Inject
constructor(
    private val repository: BookRepository
) : ViewModel(){
    init {
        println("VIEWMODEL : ${repository}")
    }

    fun getRepo() = repository
}