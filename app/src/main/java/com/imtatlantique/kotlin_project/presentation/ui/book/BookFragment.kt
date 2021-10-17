package com.imtatlantique.kotlin_project.presentation.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.imtatlantique.kotlin_project.domain.model.Book
import com.imtatlantique.kotlin_project.presentation.BaseApplication
import com.imtatlantique.kotlin_project.presentation.components.BookView
import com.imtatlantique.kotlin_project.presentation.ui.book_list.BookListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BookFragment : Fragment() {
    @Inject
    lateinit var application: BaseApplication
    //val viewModel : BookListViewModel by activityViewModels()
    private var book = Book()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getParcelable<Book>("book")?.let { b ->
            this.book = b
        }
    }


    @ExperimentalUnitApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                BookView(book = book)
            }
        }
    }
}