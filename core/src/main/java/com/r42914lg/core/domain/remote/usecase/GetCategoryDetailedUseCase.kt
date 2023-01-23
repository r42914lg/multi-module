package com.r42914lg.core.domain.remote.usecase

import androidx.lifecycle.LiveData
import com.r42914lg.core.data.remote.repository.CategoryRepository
import com.r42914lg.core.domain.remote.model.CategoryDetailed
import com.r42914lg.utils.Resource


class GetCategoryDetailedUseCase constructor(
    private val categoryRepository: CategoryRepository
) {
    fun execute(categoryId: Int): LiveData<Resource<CategoryDetailed>> {
        return categoryRepository.getCategoryDetails(categoryId)
    }
}