package com.sithuhein.mvp_example.network

import com.sithuhein.mvp_example.model.BaseResponse
import kotlinx.coroutines.flow.Flow


interface ApiHelper {
    suspend fun fetchMovies() : Flow<BaseResponse>
}