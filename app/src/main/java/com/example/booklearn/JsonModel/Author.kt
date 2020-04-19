package com.example.booklearn.JsonModel

data class Author(val name: String, val about: String,
                  val listBook: List<Book>?): JsonElement {

    override fun getNames(): String {
        return name
    }

    override fun getDescr(): String {
        return about
    }

    override fun getElem(): List<JsonElement> {
        return listBook!!
    }
}
