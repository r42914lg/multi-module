package com.r42914lg.mentor.di

import com.r42914lg.core_api.CoreApi
import com.r42914lg.core_api.domain.local.usecase.SaveCategoryUseCase
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryListUseCase
import com.r42914lg.core_impl.di.CoreComponentHolder
import com.r42914lg.core_impl.di.CoreDependencies
import com.r42914lg.feature_list.di.FeatureListDependencies
import com.r42914lg.feature_list.impl.ui.ListViewModel
import com.r42914lg.mentor.navigation.NavigationApi
import com.r42914lg.mentor.navigation.NavigationImpl
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides

@Module
interface AppModule {

    @Provides
    fun provideFeatureListDependencies(coreApi: CoreApi, navigationApi: NavigationApi): FeatureListDependencies {
        return object : FeatureListDependencies {
            override fun getVmFactory(): ListViewModel.Factory {
                
            }

            override fun getCategoryListUseCase(): GetCategoryListUseCase =
                coreApi.provideGetCategoryListUseCase()

            override fun saveCategoryUseCase(): SaveCategoryUseCase =
                coreApi.provideSaveCategoryUseCase()

            override fun goBackFromList() {
                navigationApi.goBackFromList()
            }
            override fun nextAction() {
                navigationApi.nextAction()
            }
        }
    }

    @Provides
    fun provideCoreApi(coreDependencies: CoreDependencies): CoreApi {
        CoreComponentHolder.init(coreDependencies)
        return CoreComponentHolder.get()
    }

    @Provides
    fun provideCoreDependencies(): CoreDependencies =
        object : CoreDependencies {}

    @Binds
    fun bindNavigation(@BindsInstance navigationImpl: NavigationImpl): NavigationApi
}