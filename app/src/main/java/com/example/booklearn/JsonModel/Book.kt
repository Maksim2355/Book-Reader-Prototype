package com.example.booklearn.JsonModel

data class Book(
    override val title: String, override val desc: String,
    val content: String): JsonElement()