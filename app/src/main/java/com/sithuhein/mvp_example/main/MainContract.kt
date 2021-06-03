package com.sithuhein.mvp_example.main

import com.sithuhein.mvp_example.model.Movie

class MainContract {

    interface PresenterInterface {
        fun getMovies()
        fun bind(view : ViewInterface)
    }

    interface ViewInterface {
        fun displayMovies(data : List<Movie>)
        fun displayNothing()
        fun displayMessage(message : String)
        fun displayError(error : String)
    }
}