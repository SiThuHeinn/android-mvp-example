package com.sithuhein.mvp_example.di

import com.sithuhein.mvp_example.main.repository.localDataSource.LocalDataSource
import com.sithuhein.mvp_example.main.repository.localDataSource.LocalDataSourceImpl
import com.sithuhein.mvp_example.search.repository.RemoteSearchDataSource
import com.sithuhein.mvp_example.search.repository.RemoteSearchDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindLocalData(localDataSourceImpl: LocalDataSourceImpl) : LocalDataSource

    @Binds
    abstract fun bindRemoteSearchDataSource(remoteSearchDataSourceImpl: RemoteSearchDataSourceImpl) : RemoteSearchDataSource


}