package com.example.booklearn

import android.app.Application

//Синглтона приложения
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

    }


    //Статический член
    companion object {
        var instance: App? = null
    }
}