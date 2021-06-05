package com.sithuhein.mvp_example.search

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

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){

    private val mResults = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int = mResults.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(mResults[position])
    }


    fun setResults(results : List<Movie>){
        mResults.clear()
        mResults.addAll(results)
    }


    class SearchViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(result : Movie) {
            itemView.title.text = result.title
            itemView.overview.text = result.overview
            itemView.releaseYear.text = result.releaseDate
            val url = Constants.getPosterPath(result.poster ?: " ")

            Glide.with(itemView.context)
                .load(url)
                .into(itemView.img_poster)

        }
    }
}