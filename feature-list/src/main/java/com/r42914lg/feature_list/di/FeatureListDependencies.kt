package com.r42914lg.feature_list.di;

import com.r42914lg.core_api.domain.local.usecase.SaveCategoryUseCase
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryListUseCase
import com.r42914lg.module_injector.BaseDependencies

interface FeatureListDependencies : BaseDependencies {
    fun getCategoryListUseCase(): GetCategoryListUseCase
    fun saveCategoryUseCase(): SaveCategoryUseCase
}
