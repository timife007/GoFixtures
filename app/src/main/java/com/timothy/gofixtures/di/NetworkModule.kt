package com.timothy.gofixtures.di

import com.timothy.gofixtures.data.api.ApiConstants
import com.timothy.gofixtures.data.api.interceptors.AuthenticationInterceptor
import com.timothy.gofixtures.data.api.interceptors.LoggingInterceptor
import com.timothy.gofixtures.data.api.interceptors.NetworkStatusInterceptor
import com.google.gson.Gson
import com.timothy.gofixtures.data.api.GoFixturesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder): GoFixturesApi {
        return builder.build().create(GoFixturesApi::class.java)
    }
    @Provides
    fun provideGson():Gson=Gson()

    @Provides
    fun provideGsonConverter(gson:Gson):GsonConverterFactory{
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient,gsonConverterFactory: GsonConverterFactory): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(ApiConstants.BASE_URL).client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
    }

    @Provides
    fun provideOkHttpClient(
        networkStatusInterceptor: NetworkStatusInterceptor,
        loggingInterceptor: HttpLoggingInterceptor,
        authenticationInterceptor: AuthenticationInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(networkStatusInterceptor)
            .addInterceptor(authenticationInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun provideLoggingInterceptor(loggingInterceptor: LoggingInterceptor): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(loggingInterceptor)
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }


}