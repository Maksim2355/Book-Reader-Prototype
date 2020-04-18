package com.example.booklearn.JsonModel

data class Genres(override val title: String,override val desc: String,
                  val listAuthor: List<JsonElement>): JsonElement()
