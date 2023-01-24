package com.r42914lg.core.domain.remote.usecase

import androidx.lifecycle.LiveData
import com.r42914lg.core.data.remote.repository.CategoryRepository
import com.r42914lg.core.domain.remote.model.Category
import com.r42914lg.utils.Resource
import javax.inject.Inject

interface GetCategoryListUseCase {
    fun execute(): LiveData<Resource<List<Category>>>
}

class GetCategoryListUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : GetCategoryListUseCase {

    override fun execute(): LiveData<Resource<List<Category>>> {
        return categoryRepository.getCategoryList()
    }
}