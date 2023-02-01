package com.r42914lg.core_impl.data.remote.repository

import androidx.lifecycle.liveData
import com.r42914lg.core_impl.data.remote.dataSource.CategoryDataSource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

internal class CategoryRepository @Inject constructor(
    private val categoryDataSource: CategoryDataSource
    ) {

    fun getCategoryList() = liveData(Dispatchers.IO) {
        emit(categoryDataSource.getCategoryList())
    }

    fun getCategoryDetails(categoryId: Int) = liveData(Dispatchers.IO) {
        emit(categoryDataSource.getDetails(categoryId))
    }
}