package com.example.booklearn.BookListLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.booklearn.ActivityContainFragment
import com.example.booklearn.JsonModel.Genres
import com.example.booklearn.JsonModel.JsonElement
import com.example.booklearn.UpdateAdapter
import com.example.learnbook.R


class AdapterBook(private val listItem: List<JsonElement>?, updateAdapter: UpdateAdapter,
                  private val transFragment: ActivityContainFragment): RecyclerView.Adapter<AdapterBook.ViewHolder>() {
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
         return listItem!!.size
    }

    inner class ViewHolder(v: View):
        RecyclerView.ViewHolder(v), View.OnClickListener {
        init {
            v.setOnClickListener(this)
        }
        private val idContainFragment = R.id.fr_container_book_list

        fun bind(position: Int){
            if (listItem != null && listItem[adapterPosition].getJsonLevel() != 3) {
                mTextTitle.text = listItem[position].getNames()
                mTextDesc.text = listItem[position].getDescr()
            }else{
                mTextTitle.text = listItem?.get(position)?.getNames()
            }
        }

        override fun onClick(v: View?) {

            when(listItem?.get(adapterPosition)?.getJsonLevel()){
                1-> {
                    val args = Bundle()
                    args.putInt("List", adapterPosition)
                    val fragmentTransition = WritersListFragment()
                    fragmentTransition.arguments = args
                    transFragment.replaceFragment(idContainFragment, fragmentTransition)
                }
                2->{
                    val args = Bundle()
                    args.putInt("List", adapterPosition)
                    val fragmentTransition = BookListFragment()
                    fragmentTransition.arguments = args
                    transFragment.replaceFragment(idContainFragment, fragmentTransition)
                }
                3-> {

                }
            }
        }
    }
}