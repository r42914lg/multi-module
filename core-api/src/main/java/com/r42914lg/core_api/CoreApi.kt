package com.r42914lg.core_api

import com.r42914lg.core_api.domain.local.usecase.GetCategoryUseCase
import com.r42914lg.core_api.domain.local.usecase.SaveCategoryUseCase
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryDetailedUseCase
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryListUseCase
import com.r42914lg.module_injector.BaseAPI

interface CoreApi: BaseAPI {
    fun provideGetCategoryUseCase(): GetCategoryUseCase
    fun provideSaveCategoryUseCase(): SaveCategoryUseCase
    fun provideGetCategoryDetailedUseCase(): GetCategoryDetailedUseCase
    fun provideGetCategoryListUseCase(): GetCategoryListUseCase
}