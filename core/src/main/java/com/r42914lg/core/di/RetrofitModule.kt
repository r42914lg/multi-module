package com.r42914lg.core.di

import com.r42914lg.core.data.remote.service.CategoryService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideCategoryService(): CategoryService =
        retrofit.create(CategoryService::class.java)

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://jservice.io/api/")
            .client(getOkHttp())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun getOkHttp(): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
}