package com.example.booklearn.BookListLogin


import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.example.learnbook.R

/**
 * A simple [Fragment] subclass.
 */
class ContentBookFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View  = inflater.inflate(R.layout.fragment_content_book, container, false)
        val contentTextView: TextView = v.findViewById(R.id.content)
        contentTextView.text = arguments!!.get("Content") as CharSequence?
        // Inflate the layout for this fragment
        return v
    }

}
