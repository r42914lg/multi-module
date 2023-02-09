package com.r42914lg.core_api.domain.remote.usecase

import androidx.lifecycle.LiveData
import com.r42914lg.core_api.domain.local.model.Category
import com.r42914lg.utils.Resource

interface GetCategoryListUseCase {
    fun execute(): LiveData<Resource<List<Category>>>
}