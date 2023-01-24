package com.r42914lg.core.domain.local.usecase

import com.r42914lg.core.data.local.repository.CategoryRepository
import com.r42914lg.core.domain.local.model.CategoryEntity
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

interface SaveCategoryUseCase {
    fun execute(categoryEntity: CategoryEntity)
}

class SaveCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : SaveCategoryUseCase {

    override fun execute(categoryEntity: CategoryEntity) {
        runBlocking {
            categoryRepository.saveCategory(categoryEntity)
        }
    }
}