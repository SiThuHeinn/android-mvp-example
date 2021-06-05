package com.sithuhein.mvp_example.search.repository

import com.sithuhein.mvp_example.model.BaseResponse

interface RemoteSearchDataSource {
    suspend fun searchMovie( title : String, year : Int) : BaseResponse
}