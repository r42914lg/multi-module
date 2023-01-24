package com.r42914lg.core.data.remote.dataSource

import com.r42914lg.core.data.remote.service.CategoryService
import com.r42914lg.utils.BaseDataSource
import javax.inject.Inject

class CategoryDataSource @Inject constructor(
    private val categoryService: CategoryService
) : BaseDataSource() {

    suspend fun getCategoryList() = getResult {
        categoryService.getCategories(NUM_OF_ITEMS, OFFSET)
    }

    suspend fun getDetails(categoryId: Int) = getResult {
        categoryService.getDetailedCategory(categoryId)
    }

    companion object {
        const val OFFSET = 0
        const val NUM_OF_ITEMS = 50
    }
}