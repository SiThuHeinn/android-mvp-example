package com.sithuhein.mvp_example.main

import com.sithuhein.mvp_example.main.repository.localDataSource.LocalDataSource
import com.sithuhein.mvp_example.model.Movie
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject


class MainPresenter @Inject constructor(
        private val local : LocalDataSource) : MainContract.PresenterInterface {

    private val TAG = "MainPresenter"

    private lateinit var view : MainContract.ViewInterface

    private val scope = CoroutineScope(Dispatchers.Main + Job())


    override fun bind(view: MainContract.ViewInterface) {
        this.view = view
    }

    override fun getMovies() {
            scope.launch {
                local.getMovies()
                        .collect {
                            if (it.isNullOrEmpty()){
                                local.insert(Movie(2,"Captain America","Avengers","2011","/A0knvX7rlwTyZSKj8H5NiARb45.jpg"))
                            }else
                                view.displayMovies(it)
                        }


            }
        }
    }
