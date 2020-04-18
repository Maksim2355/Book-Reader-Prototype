package com.example.booklearn.JsonModel



data class Author(
    override val title: String, override val desc: String,
    val bookList: List<JsonElement>): JsonElement()