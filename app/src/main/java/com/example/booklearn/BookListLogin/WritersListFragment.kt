package com.example.booklearn.BookListLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booklearn.ActivityContainFragment
import com.example.booklearn.JsonModel.JsonElement
import com.example.booklearn.UpdateAdapter

import com.example.learnbook.R

/**
 * A simple [Fragment] subclass.
 */
class WritersListFragment : Fragment() {
    private lateinit var genresJson: JsonParseListBook


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_writters_list, container, false)
        genresJson = activity as JsonParseListBook
        val listRecycler = v.findViewById<RecyclerView>(R.id.list_author_recycler)
        val layoutManager = LinearLayoutManager(context)
        listRecycler.layoutManager = layoutManager
        val transFragment: ActivityContainFragment = activity as ActivityContainFragment
        val numArg: Int = arguments!!.getInt("List")
        val list: List<JsonElement>? =
            genresJson.getJsonElements(null)?.get(numArg)?.getElem()
        val adapter =
            AdapterBook(list, transFragment, numArg)
        listRecycler.adapter = adapter
        // Inflate the layout for this fragment
        return v
    }

}
