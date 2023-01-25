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
import javax.inject.Singleton

@Module
interface CoreModule {

    @Binds
    @Singleton
    fun bindCategoryRepositoryRemote(impl: com.r42914lg.core.data.remote.repository.CategoryRepositoryImpl) :
            com.r42914lg.core.data.remote.repository.CategoryRepository

    @Binds
    @Singleton
    fun bindCategoryRepositoryLocal(impl: com.r42914lg.core.data.local.repository.CategoryRepositoryImpl) :
            com.r42914lg.core.data.local.repository.CategoryRepository

    @Binds
    @Singleton
    fun bindGetCategoryUseCase(impl: GetCategoryUseCaseImpl) : GetCategoryUseCase

    @Binds
    @Singleton
    fun bindSaveCategoryUseCase(impl: SaveCategoryUseCaseImpl) : SaveCategoryUseCase

    @Binds
    @Singleton
    fun bindGetCategoryDetailedUseCase(impl: GetCategoryDetailedUseCaseImpl) : GetCategoryDetailedUseCase

    @Binds
    @Singleton
    fun bindGetCategoryListUseCase(impl: GetCategoryListUseCaseImpl) : GetCategoryListUseCase
}