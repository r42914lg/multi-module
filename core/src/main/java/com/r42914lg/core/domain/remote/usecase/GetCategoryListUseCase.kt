package com.r42914lg.core.domain.remote.usecase

import androidx.lifecycle.LiveData
import com.r42914lg.core.data.remote.repository.CategoryRepository
import com.r42914lg.core.domain.remote.model.Category
import com.r42914lg.utils.Resource
import javax.inject.Inject

class GetCategoryListUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    fun execute(): LiveData<Resource<List<Category>>> {
        return categoryRepository.getCategoryList()
    }
}