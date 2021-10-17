package com.imtatlantique.kotlin_project.presentation.ui.book_list

import TAG
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.imtatlantique.kotlin_project.dependency_injection.RepositoryModule
import com.imtatlantique.kotlin_project.domain.model.Book
import com.imtatlantique.kotlin_project.repository.BookRepository
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

const val STATE_LIST_POSITION = "book.state.list_position"

@HiltViewModel
class BookListViewModel
@Inject
constructor(
    private val repository: BookRepository,
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