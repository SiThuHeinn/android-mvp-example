package com.sithuhein.mvp_example.search

import com.sithuhein.mvp_example.model.Movie

class SearchContract {

    interface SearchPresenterContract {
        fun bind(view : SearchViewContract)
        fun search(title : String, year : Int?)
        fun stop()
    }

    interface SearchViewContract {
        fun loading()
        fun showResult(result : List<Movie>)
        fun showMessage(message : String)
        fun showError(error : String)
    }

}