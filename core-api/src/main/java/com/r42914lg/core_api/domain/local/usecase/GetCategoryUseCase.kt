package com.r42914lg.core_api.domain.local.usecase

import androidx.lifecycle.LiveData
import com.r42914lg.core_api.domain.local.model.CategoryDb

interface GetCategoryUseCase {
    fun execute(id: Int): LiveData<CategoryDb?>?
}