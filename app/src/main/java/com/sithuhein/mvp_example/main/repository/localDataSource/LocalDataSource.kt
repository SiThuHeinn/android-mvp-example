package com.sithuhein.mvp_example.main.repository.localDataSource

import com.sithuhein.mvp_example.model.Movie
import kotlinx.coroutines.flow.Flow


interface LocalDataSource {

    suspend fun insert(movie : Movie)

    suspend fun getMovies() : Flow<List<Movie>>
}