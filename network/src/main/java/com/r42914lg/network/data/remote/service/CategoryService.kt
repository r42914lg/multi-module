package com.r42914lg.network.data.remote.service

import com.r42914lg.network.data.remote.model.CategoryNet
import com.r42914lg.network.data.remote.model.CategoryDetailedNet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryService {

    @GET("categories") suspend fun getCategories(
        @Query("count") amountOfCluesToReturn: Int,
        @Query("offset") offset: Int,
    ): Response<List<CategoryNet>>

    @GET("category")
    suspend fun getDetailedCategory(@Query("id") categoryId: Int): Response<CategoryDetailedNet>
}