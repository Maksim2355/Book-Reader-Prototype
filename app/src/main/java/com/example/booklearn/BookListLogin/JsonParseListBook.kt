package com.example.booklearn.BookListLogin

import com.example.booklearn.JsonModel.JsonElement

interface JsonParseListBook {

    fun getJsonElements(parent: String?): List<JsonElement>?

    fun saveJsonElement(parent: String?)

}