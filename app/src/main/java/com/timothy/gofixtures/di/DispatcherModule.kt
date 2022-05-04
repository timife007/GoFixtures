package com.timothy.gofixtures.di

import com.timothy.gofixtures.di.qualifiers.DefaultDispatcher
import com.timothy.gofixtures.di.qualifiers.IoDispatcher
import com.timothy.gofixtures.di.qualifiers.MainDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@InstallIn(SingletonComponent::class)
@Module
object DispatcherModule {
    @DefaultDispatcher
    @Provides
    fun provideDefaultDispatcher():CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun provideIoDispatcher():CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun provideMainDispatcher():CoroutineDispatcher = Dispatchers.Main

}