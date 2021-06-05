package com.sithuhein.mvp_example.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sithuhein.mvp_example.R
import com.sithuhein.mvp_example.model.Movie
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject


@AndroidEntryPoint
class SearchActivity : AppCompatActivity(), SearchContract.SearchViewContract {


    @Inject
    lateinit var presenter : SearchPresenter

    private lateinit var adapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // set up recycler view to shows results
        setUpRecyclerView()
        btnSearch.setOnClickListener {
            val title = etTitle.text.toString()
            val year = if(etYear.text.isNullOrEmpty()) null else etYear.text.toString().toInt()
            presenter.search(title, year)
        }


    }

    private fun setUpRecyclerView() {
        adapter = SearchAdapter()
        rv_search_results.layoutManager = LinearLayoutManager(this)
        rv_search_results.adapter = adapter

        rv_search_results.addItemDecoration(
            DividerItemDecoration(
                this,
                (rv_search_results.layoutManager as LinearLayoutManager).orientation
            )
        )
    }

    override fun onStart() {
        super.onStart()
        // bind this activity view contract with search presenter
        presenter.bind(this)
    }

    override fun onStop() {
        super.onStop()
        // cancel and stop coroutine when SearchActivity isn't in foreground
        presenter.stop()
    }


    override fun loading() {
        startLoading()
    }

    override fun showResult(result: List<Movie>) {
        stopLoading()
        adapter.setResults(result)
    }

    override fun showMessage(message: String) {
        stopLoading()
        error.text = message
    }

    override fun showError(err: String) {
        stopLoading()
        error.text = err
    }


    private fun stopLoading(){
        loading.visibility = View.GONE
    }

    private fun startLoading() {
        loading.visibility = View.VISIBLE
    }
}