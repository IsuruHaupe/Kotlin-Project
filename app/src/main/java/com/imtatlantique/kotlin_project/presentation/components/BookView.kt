package com.imtatlantique.kotlin_project.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imtatlantique.kotlin_project.domain.model.Book
import com.imtatlantique.kotlin_project.util.loadPicture

@Composable
fun BookView(
    book : Book
) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(scrollState)
    ) {
        book.cover?.let { url ->
            val image = loadPicture(url = url, defaultImage = 0).value
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    contentDescription = "book cover",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(225.dp),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
        book.title?.let { title ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)) {
                Text(text = title, modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .wrapContentWidth(
                        Alignment.Start
                    ),
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = "${book.price.toString()} €",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(
                            Alignment.End
                        )
                        .align(Alignment.CenterVertically),

                    style = MaterialTheme.typography.h6
                )
            }
        }
        book.synopsis?.let { resume ->
            for(text in resume){
                Text(
                    text = text,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    style = MaterialTheme.typography.body1
                )
            }
        }
        book.isbn?.let { num ->
            Text(
                text = "ISBN : $num",
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp),
                style = MaterialTheme.typography.body1
            )
        }
    }
}