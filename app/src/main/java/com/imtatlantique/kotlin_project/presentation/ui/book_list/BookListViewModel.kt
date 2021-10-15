package com.imtatlantique.kotlin_project.presentation.ui.book_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imtatlantique.kotlin_project.dependency_injection.RepositoryModule
import com.imtatlantique.kotlin_project.domain.model.Book
import com.imtatlantique.kotlin_project.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookListViewModel
@Inject
constructor(
    private val repository: BookRepository
) : ViewModel(){

    val books: MutableState<List<Book>> = mutableStateOf(ArrayList())

    init {
        searchBooks()
    }

    fun searchBooks() {
        viewModelScope.launch {
            val result = repository.query_api()
            books.value = result
        }
    }
}