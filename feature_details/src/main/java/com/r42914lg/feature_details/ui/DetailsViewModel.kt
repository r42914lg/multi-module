package com.r42914lg.feature_details.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.r42914lg.core.domain.local.model.CategoryEntity
import com.r42914lg.core.domain.local.usecase.GetCategoryUseCase
import com.r42914lg.core.domain.remote.model.CategoryDetailed
import com.r42914lg.core.domain.remote.usecase.GetCategoryDetailedUseCase
import com.r42914lg.utils.Resource

class DetailsViewModel constructor(
    getCategoryUseCase: GetCategoryUseCase,
    private val getCategoryDetailedUseCase: GetCategoryDetailedUseCase
): ViewModel() {

    private val category = getCategoryUseCase.execute(1)

    fun getDetails(): LiveData<Resource<CategoryDetailed>> {
        category?.value?.let {
            return getCategoryDetailedUseCase.execute(it.categoryId)
        }

        throw IllegalStateException("Something wrong... no data in local storage")
    }
}