package com.r42914lg.core.domain.local.usecase

import androidx.lifecycle.LiveData
import com.r42914lg.core.data.local.repository.CategoryRepository
import com.r42914lg.core.domain.local.model.CategoryEntity
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    fun execute(id: Int): LiveData<CategoryEntity?>? {
        return categoryRepository.getCategoryById(id)
    }
}