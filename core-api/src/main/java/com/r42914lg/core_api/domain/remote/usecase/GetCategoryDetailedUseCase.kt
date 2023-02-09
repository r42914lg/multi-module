package com.r42914lg.core_api.domain.remote.usecase

import androidx.lifecycle.LiveData
import com.r42914lg.core_api.domain.local.model.CategoryDetailed
import com.r42914lg.utils.Resource

interface GetCategoryDetailedUseCase {
    fun execute(categoryId: Int): LiveData<Resource<CategoryDetailed>>
}