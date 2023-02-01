package com.r42914lg.core_impl.domain.local.usecase

import com.r42914lg.core_api.domain.local.model.CategoryDb
import com.r42914lg.core_api.domain.local.usecase.SaveCategoryUseCase
import com.r42914lg.core_impl.data.local.repository.CategoryRepository
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

internal class SaveCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : SaveCategoryUseCase {

    override fun execute(categoryDb: CategoryDb) {
        runBlocking {
            categoryRepository.saveCategory(categoryDb)
        }
    }
}