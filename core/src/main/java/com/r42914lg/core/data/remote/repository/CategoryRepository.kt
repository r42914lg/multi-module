package com.r42914lg.core.data.remote.repository

import androidx.lifecycle.liveData
import com.r42914lg.core.data.remote.dataSource.CategoryDataSource
import kotlinx.coroutines.Dispatchers

class CategoryRepository constructor(private val categoryDataSource: CategoryDataSource){

    fun getCategoryList() = liveData(Dispatchers.IO) {
        emit(categoryDataSource.getCategoryList())
    }

    fun getCategoryDetails(categoryId: Int) = liveData(Dispatchers.IO) {
        emit(categoryDataSource.getDetails(categoryId))
    }
}