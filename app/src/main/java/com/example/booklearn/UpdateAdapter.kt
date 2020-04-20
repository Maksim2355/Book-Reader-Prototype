package com.example.booklearn

import com.example.booklearn.JsonModel.JsonElement

interface UpdateAdapter {
    fun updateList(listItem: List<JsonElement>, position: Int): List<JsonElement>
}