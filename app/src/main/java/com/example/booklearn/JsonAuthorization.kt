package com.example.booklearn

import com.example.booklearn.JsonModel.User

interface JsonAuthorization {

    fun getListUserJson(): List<User>?

    fun saveNewUser(userList: List<User>?, user: User)

}