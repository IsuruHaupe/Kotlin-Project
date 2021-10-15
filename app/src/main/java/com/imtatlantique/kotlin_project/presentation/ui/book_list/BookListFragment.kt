package com.imtatlantique.kotlin_project.presentation.ui.book_list

import TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.navigation.findNavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.imtatlantique.kotlin_project.R
import dagger.hilt.android.AndroidEntryPoint

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

                for(book in books){
                    Log.d(TAG, "oncreateView: ${book.title}")
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Henri Potier Collection",
                        style = TextStyle(fontSize = TextUnit(value = 21F, type = TextUnitType.Sp))
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(onClick = { findNavController().navigate(R.id.viewBook) }) {
                        Text(text = "TO BOOK")
                    }
                }
            }
        }
    }
}