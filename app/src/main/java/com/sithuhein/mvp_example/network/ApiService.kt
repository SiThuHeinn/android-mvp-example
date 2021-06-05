package com.sithuhein.mvp_example.network

import com.sithuhein.mvp_example.model.BaseResponse
import com.sithuhein.mvp_example.model.Movie
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

private const val POPULAR_MOVIE = "movie/popular"
private const val SEARCH_MOVIE = "search/movie"


interface ApiService {


    @GET(POPULAR_MOVIE)
    suspend fun fetchMovies() : BaseResponse

    @GET(SEARCH_MOVIE)
    suspend fun searchMovie(
        @Query("query") title : String,
        @Query("year") year : Int
    ) : BaseResponse

}