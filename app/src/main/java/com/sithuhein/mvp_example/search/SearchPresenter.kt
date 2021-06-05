package com.sithuhein.mvp_example.search

import android.util.Log
import com.sithuhein.mvp_example.search.repository.RemoteSearchDataSource
import kotlinx.coroutines.*
import java.lang.Exception
import javax.inject.Inject

class SearchPresenter @Inject constructor(
    private val remote : RemoteSearchDataSource
) : SearchContract.SearchPresenterContract {


    private lateinit var view : SearchContract.SearchViewContract

    private val scope = CoroutineScope(Dispatchers.Main + Job())

    override fun bind(view: SearchContract.SearchViewContract) {
        this.view = view
    }

    override fun search(title: String, year: Int?) {
        scope.launch {
            try {
                view.loading()
                val results = remote.searchMovie(title, year ?: 0)
               view.showResult(result = results.results)
            } catch (e : Exception) {
                view.showError(e.message!!)
                Log.d("Result error", "${e.message}")
            }
        }

    }

    override fun stop() {
        // Cancel the job when user quit the view
        scope.cancel()
    }

}