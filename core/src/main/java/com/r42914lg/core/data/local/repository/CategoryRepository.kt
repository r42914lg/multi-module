package com.r42914lg.core.data.local.repository

import androidx.lifecycle.LiveData
import com.r42914lg.core.data.local.dao.CategoryDao
import com.r42914lg.core.domain.local.model.CategoryEntity
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val categoryDao: CategoryDao) {

    suspend fun saveCategory(category: CategoryEntity) {
        categoryDao.insertCategory(category)
    }

    fun getCategoryById(id: Int): LiveData<CategoryEntity?>? {
        return categoryDao.getCategoryById(id)
    }
}