package com.imtatlantique.kotlin_project.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val isbn: String? = null,
    val title: String? = null,
    val price : Int? = null,
    val cover : String? = null,
    val synopsis : List<String>? = null
    ) : Parcelable