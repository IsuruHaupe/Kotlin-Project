package com.imtatlantique.kotlin_project.network.model

import com.google.gson.annotations.SerializedName

data class BookDto(
    @SerializedName("isbn")
    var isbn : String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("price")
    val price : Int? = null,

    @SerializedName("cover")
    val cover : String? = null,

    @SerializedName("synopsis")
    val synopsis : List<String>? = null
)