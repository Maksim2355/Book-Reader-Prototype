 package com.example.booklearn.BookListLogin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booklearn.ActivityContainFragment
import com.example.booklearn.JsonModel.JsonElement
import com.example.booklearn.UpdateAdapter
import com.example.learnbook.R

 /**
 * A simple [Fragment] subclass.
 */
class BookListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_book_list, container, false)
        val genresJson = activity as JsonParseListBook
        val listRecycler = v.findViewById<RecyclerView>(R.id.list_book_recycler)
        val layoutManager = LinearLayoutManager(context)
        listRecycler.layoutManager = layoutManager
        val transFragment: ActivityContainFragment = activity as ActivityContainFragment
        val listItem: List<JsonElement>?
                = genresJson.getJsonElements(null)?.get(arguments!!.getInt("List"))?.getElem()
            ?.get(arguments!!.getInt("List2"))?.getElem()
        val adapter =
            AdapterBook(listItem, transFragment)
        listRecycler.adapter = adapter
        // Inflate the layout for this fragment
        return v
    }

}
