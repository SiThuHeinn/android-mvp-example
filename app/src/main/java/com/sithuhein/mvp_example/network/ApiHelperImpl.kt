package com.sithuhein.mvp_example.network

import com.sithuhein.mvp_example.model.BaseResponse
import com.sithuhein.mvp_example.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService): ApiHelper {
    override suspend fun fetchMovies() = apiService.fetchMovies()
}