package com.example.booklearn.JsonModel

data class Author(val name: String, val about: String,
                  val bookList: List<Book>?): JsonElement {

    override fun getNames(): String {
        return name
    }

    override fun getDescr(): String {
        return about
    }

    override fun getElem(): List<JsonElement> {
        return bookList!!
    }

    override fun getJsonLevel(): Int {
        return 2
    }
}
