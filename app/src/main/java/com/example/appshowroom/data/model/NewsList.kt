package com.example.appshowroom.data.model

data class NewsList (
    val Count : Int = 0,
    val Message: String = "",
    val SearchChriteria: String = "",
    val Result: List<News> = arrayListOf(),

)