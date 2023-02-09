package com.r42914lg.core_impl.domain.local.usecase

import androidx.lifecycle.LiveData
import com.r42914lg.core_api.domain.local.model.CategoryDb
import com.r42914lg.core_api.domain.local.usecase.GetCategoryUseCase
import com.r42914lg.core_impl.data.local.repository.CategoryRepository
import javax.inject.Inject

internal class GetCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : GetCategoryUseCase {

    override fun execute(id: Int): LiveData<CategoryDb?>? {
        return categoryRepository.getCategoryById(id)
    }
}