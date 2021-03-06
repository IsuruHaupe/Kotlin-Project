package com.imtatlantique.kotlin_project

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.imtatlantique.kotlin_project.domain.model.Book
import com.imtatlantique.kotlin_project.util.loadPicture

@Composable
fun BookCard(
    book : Book,
    onClick : ()-> Unit
){
    Card (
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
            ) {
        Column {
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
                        text = "${book.price.toString()} ???",
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
        }
    }
}