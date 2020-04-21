package com.example.booklearn.JsonModel

data class Book(val nameBook: String,
                val content: String): JsonElement {
    override fun getNames(): String {
        return nameBook
    }

    override fun getDescr(): String {
        return content
    }

    override fun getElem(): List<JsonElement>? {
        return null
    }

    override fun getJsonLevel(): Int {
        return 3
    }
}