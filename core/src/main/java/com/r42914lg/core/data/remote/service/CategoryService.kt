package com.r42914lg.core.data.remote.service

import com.r42914lg.core.domain.remote.model.Category
import com.r42914lg.core.domain.remote.model.CategoryDetailed
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryService {

    @GET("categories") suspend fun getCategories(
        @Query("count") amountOfCluesToReturn: Int,
        @Query("offset") offset: Int,
    ): Response<List<Category>>

    @GET("category")
    suspend fun getDetailedCategory(@Query("id") categoryId: Int): Response<CategoryDetailed>
}