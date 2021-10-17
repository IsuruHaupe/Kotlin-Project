package com.imtatlantique.kotlin_project.presentation.ui.book_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.imtatlantique.kotlin_project.BookCard
import com.imtatlantique.kotlin_project.R
import dagger.hilt.android.AndroidEntryPoint

const val SELECTED_BOOK = "book.state.selected_book"

@AndroidEntryPoint
class BookListFragment : Fragment() {
    val viewModel : BookListViewModel by activityViewModels()

    @ExperimentalUnitApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val books = viewModel.books.value

                LazyColumn{
                    itemsIndexed(
                        items = books
                    ) { _, book ->
                        BookCard(book = book, onClick = {
                            val bundle = Bundle()
                            bundle.putParcelable("book", book)
                            findNavController().navigate(R.id.viewBook, bundle)
                        })
                    }
                }
            }
        }
    }
}