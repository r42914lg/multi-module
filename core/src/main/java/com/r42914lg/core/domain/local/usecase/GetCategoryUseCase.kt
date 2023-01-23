package com.r42914lg.core.domain.local.usecase

import androidx.lifecycle.LiveData
import com.r42914lg.core.data.local.repository.CategoryRepository
import com.r42914lg.core.domain.local.model.CategoryEntity

class GetCategoryUseCase constructor(
    private val categoryRepository: CategoryRepository
) {
    fun execute(categoryId: Int): LiveData<CategoryEntity?>? {
        return categoryRepository.getCategoryById(categoryId)
    }
}