package com.r42914lg.core.di

import com.r42914lg.core.domain.local.usecase.GetCategoryUseCase
import com.r42914lg.core.domain.local.usecase.GetCategoryUseCaseImpl
import com.r42914lg.core.domain.local.usecase.SaveCategoryUseCase
import com.r42914lg.core.domain.local.usecase.SaveCategoryUseCaseImpl
import com.r42914lg.core.domain.remote.usecase.GetCategoryDetailedUseCase
import com.r42914lg.core.domain.remote.usecase.GetCategoryDetailedUseCaseImpl
import com.r42914lg.core.domain.remote.usecase.GetCategoryListUseCase
import com.r42914lg.core.domain.remote.usecase.GetCategoryListUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface CoreModule {

    @Binds
    fun bindCategoryRepositoryRemote(impl: com.r42914lg.core.data.remote.repository.CategoryRepositoryImpl) :
            com.r42914lg.core.data.remote.repository.CategoryRepository

    @Binds
    fun bindCategoryRepositoryLocal(impl: com.r42914lg.core.data.local.repository.CategoryRepositoryImpl) :
            com.r42914lg.core.data.local.repository.CategoryRepository

    @Binds
    fun bindGetCategoryUseCase(impl: GetCategoryUseCaseImpl) : GetCategoryUseCase

    @Binds
    fun bindSaveCategoryUseCase(impl: SaveCategoryUseCaseImpl) : SaveCategoryUseCase

    @Binds
    fun bindGetCategoryDetailedUseCase(impl: GetCategoryDetailedUseCaseImpl) : GetCategoryDetailedUseCase

    @Binds
    fun bindGetCategoryListUseCase(impl: GetCategoryListUseCaseImpl) : GetCategoryListUseCase
}