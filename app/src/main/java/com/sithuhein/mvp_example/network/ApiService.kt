package com.sithuhein.mvp_example.network

import com.sithuhein.mvp_example.model.BaseResponse
import com.sithuhein.mvp_example.model.Movie
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET


interface ApiService {

    @GET("/movie/popular")
    suspend fun fetchMovies() : Flow<BaseResponse>
}