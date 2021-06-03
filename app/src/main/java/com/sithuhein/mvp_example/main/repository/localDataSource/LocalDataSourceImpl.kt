package com.sithuhein.mvp_example.main.repository.localDataSource

import com.sithuhein.mvp_example.db.AppDatabase
import com.sithuhein.mvp_example.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val appDatabase: AppDatabase) : LocalDataSource {

    override suspend fun insert(movie: Movie) {
        appDatabase.appDao().insert(movie)
    }

    override suspend fun getMovies(): Flow<List<Movie>> {
        return appDatabase.appDao().getMovies()
    }

}