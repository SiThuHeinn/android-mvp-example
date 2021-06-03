package com.sithuhein.mvp_example.main.repository.remoteDataSource

import com.sithuhein.mvp_example.model.BaseResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun fetchMovies() : Flow<BaseResponse>
}