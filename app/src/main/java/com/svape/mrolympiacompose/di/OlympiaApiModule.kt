package com.svape.mrolympiacompose.di

import com.svape.mrolympiacompose.data.api.ApiConstants
import com.svape.mrolympiacompose.data.api.OlympiaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OlympiaApiModule {

    private val interceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
    private val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder) : OlympiaApi {
        return builder
            .build()
            .create(OlympiaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BaseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
    }
}