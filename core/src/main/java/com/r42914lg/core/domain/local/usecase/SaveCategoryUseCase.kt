package com.r42914lg.core.domain.local.usecase

import com.r42914lg.core.data.local.repository.CategoryRepository
import com.r42914lg.core.domain.local.model.CategoryEntity
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class SaveCategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    fun execute(categoryEntity: CategoryEntity) {
        runBlocking {
            categoryRepository.saveCategory(categoryEntity)
        }
    }
}