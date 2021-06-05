package com.sithuhein.mvp_example.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sithuhein.mvp_example.R
import com.sithuhein.mvp_example.model.Movie
import com.sithuhein.mvp_example.utils.Constants
import kotlinx.android.synthetic.main.item_movie.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MovieViewHolder>() {

    private val mData : MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(mData[position])
    }


    fun setMovies(data : List<Movie>) {
        mData.clear()
        mData.addAll(data)
        notifyDataSetChanged()
    }


    class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bind(data : Movie) {
            itemView.title.text = data.title
            itemView.overview.text = data.overview
            itemView.releaseYear.text = data.releaseDate

            Glide.with(itemView.context)
                    .load(Constants.getPosterPath(data.poster ?: " "))
                    .into(itemView.img_poster)

        }
    }
}