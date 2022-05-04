package com.timothy.gofixtures.di

import com.timothy.gofixtures.data.api.datasource.RemoteFixturesDataSource
import com.timothy.gofixtures.data.api.datasource.RemoteFixturesDataSourceImpl
import com.timothy.gofixtures.data.cache.datasource.LocalFixturesDataSource
import com.timothy.gofixtures.data.cache.datasource.LocalFixturesDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun provideRemote(remoteDataSourceImpl: RemoteFixturesDataSourceImpl):RemoteFixturesDataSource

    @Binds
    abstract fun provideLocal(localDataSourceImpl: LocalFixturesDataSourceImpl):LocalFixturesDataSource


}