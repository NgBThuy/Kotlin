package com.khtn.androidcamp.upbook


import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khtn.androidcamp.MainActivity
import com.khtn.androidcamp.R
import java.util.ArrayList

class BookAdapter(private val bActivity: MainActivity) : RecyclerView.Adapter<BookViewHolder>() {
    private val mData: MutableList<Information>?
    private val mLayoutInflater: LayoutInflater

    private val listener = object : BookViewHolder.OnBookViewHolderListener {
        override fun onClick(position: Int) {

        }

        override fun onLongClick(position: Int) {

        }
    }


    init {
        mLayoutInflater = LayoutInflater.from(bActivity)
        mData = ArrayList()
    }

    fun setData(data: List<Information>) {
        mData!!.clear()
        mData.addAll(data)
        notifyDataSetChanged()
    }

    fun addData(data: Information) {
        mData!!.add(data)
        notifyItemInserted(mData.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = mLayoutInflater.inflate(R.layout.row_book, parent, false)
        return BookViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val entity = mData!![position]
        holder.renderUi(position, entity)

        /*holder.itemView.setOnClickListener{
            View.OnClickListener {
                val intent = Intent(bActivity, DetailBookActivity::class.java)
                intent.putExtra("id", entity[position].id)
                bActivity.startActivity(intent)
            }
        }*/
    }

    override fun getItemCount(): Int {
        return mData?.size ?: 0
    }

    companion object {
        private val TAGG = BookAdapter::class.java.simpleName
    }
}
