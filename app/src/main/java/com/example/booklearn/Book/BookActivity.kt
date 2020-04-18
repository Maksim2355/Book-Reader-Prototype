package com.example.booklearn.Book

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.booklearn.ActivityContainFragment
import com.example.learnbook.R

class BookActivity : AppCompatActivity(), ActivityContainFragment {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun getFragment(): Fragment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun replaceFragment(frCont: Int, fr: Fragment) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addFragment(frCont: Int, fr: Fragment) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun removeFragment(fr: Fragment) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
