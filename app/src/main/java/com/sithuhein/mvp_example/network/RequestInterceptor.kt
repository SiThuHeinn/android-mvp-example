package com.sithuhein.mvp_example.network

import com.sithuhein.mvp_example.di.ApiKey
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class RequestInterceptor(private val apiKey: String) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()


        val mRequest = originalRequest
                .url()
                .newBuilder()
                .addQueryParameter("api_key", apiKey)
                .build()

        val newRequest = chain.request()
                .newBuilder()
                .url(mRequest)
                .build()

        return  chain.proceed(newRequest)
    }
}