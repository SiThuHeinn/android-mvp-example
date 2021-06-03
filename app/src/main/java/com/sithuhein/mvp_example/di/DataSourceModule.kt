package com.sithuhein.mvp_example.di

import com.sithuhein.mvp_example.main.repository.localDataSource.LocalDataSource
import com.sithuhein.mvp_example.main.repository.localDataSource.LocalDataSourceImpl
import com.sithuhein.mvp_example.main.repository.remoteDataSource.RemoteDataSource
import com.sithuhein.mvp_example.main.repository.remoteDataSource.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(ActivityComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindRemoteData(remoteDataSourceImpl: RemoteDataSourceImpl) : RemoteDataSource


    @Binds
    abstract fun bindLocalData(localDataSourceImpl: LocalDataSourceImpl) : LocalDataSource

}