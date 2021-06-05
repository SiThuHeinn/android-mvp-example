package com.sithuhein.mvp_example.search.repository

import com.sithuhein.mvp_example.model.BaseResponse
import com.sithuhein.mvp_example.network.ApiHelper
import com.sithuhein.mvp_example.network.ApiService
import javax.inject.Inject


class RemoteSearchDataSourceImpl @Inject constructor(private val apiHelper: ApiHelper) : RemoteSearchDataSource {

    override suspend fun searchMovie(title: String, year: Int) : BaseResponse {
        return apiHelper.search(title, year)
    }

}