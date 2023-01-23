package com.r42914lg.core.data.local.repository

import androidx.lifecycle.LiveData
import com.r42914lg.core.data.local.dao.CategoryDao
import com.r42914lg.core.domain.local.model.CategoryEntity

class CategoryRepository constructor(private val categoryDao: CategoryDao) {

    suspend fun saveCategory(category: CategoryEntity) {
        categoryDao.insertCategory(category)
    }

    fun getCategoryById(categoryId: Int): LiveData<CategoryEntity?>? {
        return categoryDao.getCategoryById(categoryId)
    }
}