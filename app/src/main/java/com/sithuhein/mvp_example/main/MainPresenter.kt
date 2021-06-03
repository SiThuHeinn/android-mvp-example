package com.sithuhein.mvp_example.main

import com.sithuhein.mvp_example.main.repository.localDataSource.LocalDataSource
import com.sithuhein.mvp_example.model.Movie
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class MainPresenter @Inject constructor(
    private val localDataSource : LocalDataSource) : MainContract.PresenterInterface
{

    private val TAG = "MainPresenter"

    private lateinit var view : MainContract.ViewInterface

    override fun bind(view: MainContract.ViewInterface) {
        this.view = view
    }

    override fun getMovies() {
            GlobalScope.launch {
                localDataSource.getMovies()
                        .collect {
                            if (it.isNullOrEmpty()){
                                localDataSource.insert(Movie(2,"Captain America","Avengers","2011","Poster Path"))
                            }else
                                view.displayMovies(it)
                        }


            }
        }
    }
