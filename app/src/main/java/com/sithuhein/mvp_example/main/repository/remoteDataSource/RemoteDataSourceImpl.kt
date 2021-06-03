package com.sithuhein.mvp_example.main.repository.remoteDataSource

import com.sithuhein.mvp_example.model.BaseResponse
import com.sithuhein.mvp_example.network.ApiHelper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiHelper : ApiHelper): RemoteDataSource {

    override suspend fun fetchMovies(): Flow<BaseResponse> {
        return apiHelper.fetchMovies()
    }
}