package com.example.booklearn.BookListLogin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.booklearn.JsonModel.JsonElement
import com.example.learnbook.R


class AdapterBook(private val listItem: List<JsonElement>): RecyclerView.Adapter<AdapterBook.ViewHolder>() {
    private lateinit var mTextTitle: TextView
    private lateinit var mTextDesc: TextView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterBook.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val v = inflater.inflate(R.layout.item, parent, false)
        mTextTitle = v.findViewById(R.id.title_item)
        mTextDesc =  v.findViewById(R.id.desc_item)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdapterBook.ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
         return listItem.size
    }

    inner class ViewHolder(v: View):
        RecyclerView.ViewHolder(v), View.OnClickListener {


        fun bind(position: Int){
            mTextTitle.text = listItem[position].title
            mTextDesc.text = listItem[position].desc
        }

        override fun onClick(v: View?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}