package com.khtn.androidcamp.upbook

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.khtn.androidcamp.R

class BookViewHolder(view: View, private val mListener: OnBookViewHolderListener?) : RecyclerView.ViewHolder(view),
    View.OnClickListener, View.OnLongClickListener {

    private var bposition = 0
    private val item: Information? = null

    private val tv_dt_namebook: TextView
    private val tv_dt_info_book: TextView
    private val tv_dt_author: TextView
    private val tv_dt_city: TextView
    private val tv_dt_contact: TextView

    interface OnBookViewHolderListener {
        fun onClick(position: Int)

        fun onLongClick(position: Int)
    }

    init {
        view.setOnClickListener(this)
        view.setOnLongClickListener(this)
        tv_dt_namebook = view.findViewById(R.id.tv_dt_namebook)
        tv_dt_info_book = view.findViewById(R.id.tv_dt_info_book)
        tv_dt_author = view.findViewById(R.id.tv_dt_author)
        tv_dt_city = view.findViewById(R.id.tv_dt_city)
        tv_dt_contact = view.findViewById(R.id.tv_dt_contact)


    }

    fun renderUi(position: Int, entity: Information) {
        this.bposition = position
        tv_dt_namebook.text = entity.name_book
        tv_dt_info_book.text = entity.info_book
        tv_dt_author.text = entity.author
        tv_dt_city.text = entity.city
        tv_dt_contact.text = entity.contact


    }

    override fun onClick(v: View) {
        mListener?.onClick(bposition)
    }

    override fun onLongClick(v: View): Boolean {
        mListener?.onLongClick(bposition)
        return false
    }
}