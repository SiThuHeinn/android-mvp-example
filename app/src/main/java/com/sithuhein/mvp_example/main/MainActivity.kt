package com.sithuhein.mvp_example.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sithuhein.mvp_example.R
import com.sithuhein.mvp_example.model.Movie
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainContract.ViewInterface {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onStart() {
        super.onStart()
        mainPresenter.bind(this)
        mainPresenter.getMovies()

    }



    override fun displayMovies(data : List<Movie>) {
        Log.d("Movie List","Movie : ${data[0].title} ${data[0].overview} ${data[0].releaseDate}")
    }

    override fun displayNothing() {

    }

    override fun displayMessage(message : String) {

    }

    override fun displayError(error : String) {

    }
}