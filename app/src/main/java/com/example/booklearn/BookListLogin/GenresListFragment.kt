package com.example.booklearn.BookListLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.learnbook.R

/**
 * A simple [Fragment] subclass.
 */
class GenresListFragment : Fragment() {
    private lateinit var genresJson: JsonParseListBook

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_genres_list, container, false)
        genresJson = activity as JsonParseListBook
        val listRecycler = v.findViewById<RecyclerView>(R.id.list_genres_recycler)
        val layoutManager = LinearLayoutManager(context)
        listRecycler.layoutManager = layoutManager

        return v
    }

}
