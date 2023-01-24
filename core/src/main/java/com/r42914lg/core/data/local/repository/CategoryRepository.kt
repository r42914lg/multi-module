package com.r42914lg.core.data.local.repository

import androidx.lifecycle.LiveData
import com.r42914lg.core.data.local.dao.CategoryDao
import com.r42914lg.core.domain.local.model.CategoryEntity
import com.r42914lg.core.domain.remote.model.Category
import com.r42914lg.core.domain.remote.model.CategoryDetailed
import com.r42914lg.utils.Resource
import javax.inject.Inject

interface CategoryRepository {
    suspend fun saveCategory(category: CategoryEntity)
    fun getCategoryById(id: Int): LiveData<CategoryEntity?>?
}

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDao: CategoryDao
    ) : CategoryRepository {

    override suspend fun saveCategory(category: CategoryEntity) {
        categoryDao.insertCategory(category)
    }

    override fun getCategoryById(id: Int): LiveData<CategoryEntity?>? {
        return categoryDao.getCategoryById(id)
    }
}