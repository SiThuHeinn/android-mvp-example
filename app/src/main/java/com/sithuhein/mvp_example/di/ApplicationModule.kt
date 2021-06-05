package com.sithuhein.mvp_example.di

import android.content.Context
import androidx.room.Room
import com.sithuhein.mvp_example.db.AppDatabase
import com.sithuhein.mvp_example.network.ApiHelper
import com.sithuhein.mvp_example.network.ApiHelperImpl
import com.sithuhein.mvp_example.network.ApiService
import com.sithuhein.mvp_example.network.RequestInterceptor
import com.sithuhein.mvp_example.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @ApiKey
    @Provides
    @Singleton
    fun provideApiKey() = "dc6f6d4cc6c09db8ca384d0d85b538cd"

    @PhotoBaseUrl
    @Provides
    @Singleton
    fun providePhotoBaseUrl() = "http://image.tmdb.org/t/p/w185"



    @Provides
    @Singleton
    fun provideOkHttpClient(@ApiKey apiKey : String): OkHttpClient {
        val requestInterceptor = RequestInterceptor(apiKey)
        return OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .build()
    }


    @Provides
    @Singleton
     fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()



    @Provides
    @Singleton
    fun provideApiService(retrofit : Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl) : ApiHelper = apiHelper


    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "movie")
            .build()


}