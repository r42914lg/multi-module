package com.r42914lg.core.domain.local.usecase

import com.r42914lg.core.data.local.repository.CategoryRepository
import com.r42914lg.core.domain.local.model.CategoryEntity
import kotlinx.coroutines.runBlocking

class SaveCategoryUseCase constructor(
    private val categoryRepository: CategoryRepository
) {
    fun execute(categoryEntity: CategoryEntity) {
        runBlocking {
            categoryRepository.saveCategory(categoryEntity)
        }
    }
}