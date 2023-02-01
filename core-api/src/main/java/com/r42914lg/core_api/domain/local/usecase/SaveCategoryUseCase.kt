package com.r42914lg.core_api.domain.local.usecase

import com.r42914lg.core_api.domain.local.model.CategoryDb

interface SaveCategoryUseCase {
    fun execute(categoryDb: CategoryDb)
}