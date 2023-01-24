package com.r42914lg.core.data.remote.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.r42914lg.core.data.remote.dataSource.CategoryDataSource
import com.r42914lg.core.domain.remote.model.Category
import com.r42914lg.core.domain.remote.model.CategoryDetailed
import com.r42914lg.utils.Resource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

interface CategoryRepository {
    fun getCategoryList() : LiveData<Resource<List<Category>>>
    fun getCategoryDetails(categoryId: Int) : LiveData<Resource<CategoryDetailed>>
}

class CategoryRepositoryImpl @Inject constructor(
    private val categoryDataSource: CategoryDataSource
    ) : CategoryRepository {

    override fun getCategoryList() = liveData(Dispatchers.IO) {
        emit(categoryDataSource.getCategoryList())
    }

    override fun getCategoryDetails(categoryId: Int) = liveData(Dispatchers.IO) {
        emit(categoryDataSource.getDetails(categoryId))
    }
}