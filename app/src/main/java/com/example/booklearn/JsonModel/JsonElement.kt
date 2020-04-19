package com.example.booklearn.JsonModel

interface JsonElement{

    fun getNames(): String

    fun getDescr(): String

    fun getElem(): List<JsonElement>

}