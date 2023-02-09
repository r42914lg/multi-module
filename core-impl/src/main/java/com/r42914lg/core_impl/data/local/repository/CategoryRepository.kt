package com.r42914lg.core_impl.data.local.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.r42914lg.core_api.domain.local.model.CategoryDb
import com.r42914lg.db.data.local.dao.CategoryDao
import com.r42914lg.db.data.local.model.CategoryEntity
import javax.inject.Inject

internal class CategoryRepository @Inject constructor(
    private val categoryDao: CategoryDao
    ) {

    suspend fun saveCategory(categoryDb: CategoryDb) {
        categoryDao.insertCategory(CategoryEntity(categoryDb.id, categoryDb.categoryId))
    }

    fun getCategoryById(id: Int): LiveData<CategoryDb?>? {
        val dbRes = categoryDao.getCategoryById(id) ?: return null

        return Transformations.map(dbRes) { CategoryDb(it!!.id, it.categoryId) }
    }
}