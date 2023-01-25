package com.r42914lg.core.di

import android.app.Application
import com.r42914lg.core.domain.local.usecase.GetCategoryUseCase
import com.r42914lg.core.domain.local.usecase.SaveCategoryUseCase
import com.r42914lg.core.domain.remote.usecase.GetCategoryDetailedUseCase
import com.r42914lg.core.domain.remote.usecase.GetCategoryListUseCase
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

interface CoreComponentContract {
    fun exposeGetCategoryUseCase(): GetCategoryUseCase
    fun exposeSaveCategoryUseCase(): SaveCategoryUseCase
    fun exposeGetCategoryDetailedUseCase(): GetCategoryDetailedUseCase
    fun exposeGetCategoryListUseCase(): GetCategoryListUseCase
}

@Component(modules = [
    RoomModule::class,
    RetrofitModule::class,
    CoreModule::class,
])
@Singleton
interface CoreComponent : CoreComponentContract {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): CoreComponent
    }

    override fun exposeGetCategoryUseCase(): GetCategoryUseCase
    override fun exposeSaveCategoryUseCase(): SaveCategoryUseCase
    override fun exposeGetCategoryDetailedUseCase(): GetCategoryDetailedUseCase
    override fun exposeGetCategoryListUseCase(): GetCategoryListUseCase
}