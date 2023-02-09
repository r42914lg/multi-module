package com.r42914lg.core_impl.domain.remote.usecase

import androidx.lifecycle.LiveData
import com.r42914lg.core_api.domain.local.model.CategoryDetailed
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryDetailedUseCase
import com.r42914lg.core_impl.data.remote.repository.CategoryRepository
import com.r42914lg.utils.Resource
import javax.inject.Inject

internal class GetCategoryDetailedUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : GetCategoryDetailedUseCase {

    override fun execute(categoryId: Int): LiveData<Resource<CategoryDetailed>> {
        return categoryRepository.getCategoryDetails(categoryId)
    }
}