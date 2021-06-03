package com.sithuhein.mvp_example.di

import android.content.Context
import androidx.room.Room
import com.sithuhein.mvp_example.BuildConfig
import com.sithuhein.mvp_example.db.AppDatabase
import com.sithuhein.mvp_example.network.ApiHelper
import com.sithuhein.mvp_example.network.ApiHelperImpl
import com.sithuhein.mvp_example.network.ApiService
import com.sithuhein.mvp_example.utils.baseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
    fun provideOkHttpClient(): OkHttpClient? = if (BuildConfig.DEBUG ) {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

    } else
        OkHttpClient.Builder().build()


    @Provides
    @Singleton
     fun provideRetrofit(): Retrofit? =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(provideOkHttpClient()!!)
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