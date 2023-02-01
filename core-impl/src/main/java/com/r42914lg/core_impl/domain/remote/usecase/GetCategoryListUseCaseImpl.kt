package com.r42914lg.core_impl.domain.remote.usecase

import androidx.lifecycle.LiveData
import com.r42914lg.core_api.domain.remote.model.Category
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryListUseCase
import com.r42914lg.core_impl.data.remote.repository.CategoryRepository
import com.r42914lg.utils.Resource
import javax.inject.Inject

internal class GetCategoryListUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : GetCategoryListUseCase {

    override fun execute(): LiveData<Resource<List<Category>>> {
        return categoryRepository.getCategoryList()
    }
}