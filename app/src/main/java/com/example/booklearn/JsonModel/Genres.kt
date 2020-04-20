package com.example.booklearn.JsonModel

data class Genres(val Title: String, private val desc: String,
                  val listAuthor: List<Author>?): JsonElement {
    override fun getNames(): String {
        return Title
    }

    override fun getDescr(): String {
        return desc
    }

    override fun getElem(): List<JsonElement> {
        return listAuthor!!
    }

    override fun getJsonLevel(): Int {
        return 1
    }
}
