package com.r42914lg.core_impl.di

import com.r42914lg.core_api.domain.local.usecase.GetCategoryUseCase
import com.r42914lg.core_api.domain.local.usecase.SaveCategoryUseCase
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryDetailedUseCase
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryListUseCase
import com.r42914lg.core_impl.domain.local.usecase.GetCategoryUseCaseImpl
import com.r42914lg.core_impl.domain.local.usecase.SaveCategoryUseCaseImpl
import com.r42914lg.core_impl.domain.remote.usecase.GetCategoryDetailedUseCaseImpl
import com.r42914lg.core_impl.domain.remote.usecase.GetCategoryListUseCaseImpl
import dagger.Binds
import dagger.BindsInstance
import dagger.Module

@Module
internal interface CoreModule {

    @Binds
    fun bindGetCategoryUseCase(
        @BindsInstance impl: GetCategoryUseCaseImpl
    ) : GetCategoryUseCase

    @Binds
    fun bindGetCategoryDetailedUseCase(
        @BindsInstance impl: GetCategoryDetailedUseCaseImpl
    ) : GetCategoryDetailedUseCase

    @Binds
    fun bindGetCategoryListUseCase(
        @BindsInstance impl: GetCategoryListUseCaseImpl
    ) : GetCategoryListUseCase

    @Binds
    fun bindSaveCategoryUseCase(
        @BindsInstance impl: SaveCategoryUseCaseImpl
    ) : SaveCategoryUseCase

}