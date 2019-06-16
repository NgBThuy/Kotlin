package com.hnam.recyclerview

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*


class MoviesAdapter(var items: ArrayList<MoviesModel>, val context: Context) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }


    override fun onBindViewHolder(movieViewHolder: MovieViewHolder, position: Int) {
        movieViewHolder.ititle.text = items[position].title
        movieViewHolder.ioverview.text = items[position].overview
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/w500/" + items[position].poster_path)
            .into(movieViewHolder.iposter)


        movieViewHolder.itemView.setOnClickListener {
            View.OnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("id", items[position].id)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iposter = view.iposter
        var ititle = view.ititle
        var ioverview = view.ioverview

    }
}
