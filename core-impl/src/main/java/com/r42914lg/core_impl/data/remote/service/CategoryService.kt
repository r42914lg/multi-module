package com.r42914lg.core_impl.data.remote.service

import com.r42914lg.core_api.domain.remote.model.Category
import com.r42914lg.core_api.domain.remote.model.CategoryDetailed
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface CategoryService {

    @GET("categories") suspend fun getCategories(
        @Query("count") amountOfCluesToReturn: Int,
        @Query("offset") offset: Int,
    ): Response<List<Category>>

    @GET("category")
    suspend fun getDetailedCategory(@Query("id") categoryId: Int): Response<CategoryDetailed>
}