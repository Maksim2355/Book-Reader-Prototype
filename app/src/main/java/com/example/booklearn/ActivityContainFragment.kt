package com.example.booklearn

import androidx.fragment.app.Fragment


interface ActivityContainFragment {

    //Метод получение текущего фрагмента в активности
    fun getFragment(): Fragment

    //Метод замены фрагментов. На вход получаем название контейнера и сам фрагмент
    fun replaceFragment(frCont: Int, fr: Fragment)

    //Добавление фрагмента
    fun addFragment(frCont: Int, fr: Fragment)

    //Удаление фрагмента
    fun removeFragment(fr: Fragment)

}