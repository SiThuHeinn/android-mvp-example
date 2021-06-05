package com.sithuhein.mvp_example.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sithuhein.mvp_example.R
import com.sithuhein.mvp_example.model.Movie
import com.sithuhein.mvp_example.search.SearchActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainContract.ViewInterface {

    @Inject
    lateinit var mainPresenter: MainPresenter

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()

        // Fab OnClick
        fabSearch.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

    }




    override fun onStart() {
        super.onStart()
        mainPresenter.bind(this)
        mainPresenter.getMovies()

    }


    private fun setUpRecyclerView() {
        adapter = MainAdapter()
        main_rv.layoutManager = LinearLayoutManager(this)
        main_rv.addItemDecoration(
                DividerItemDecoration(
                        this,
                        (main_rv.layoutManager as LinearLayoutManager).orientation
                )
        )
        main_rv.adapter = adapter

    }

    override fun displayMovies(data : List<Movie>) {
        adapter.setMovies(data)
    }

    override fun displayNothing() {

    }

    override fun displayMessage(message : String) {

    }

    override fun displayError(error : String) {

    }
}