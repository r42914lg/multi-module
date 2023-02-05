package com.r42914lg.mentor.di

import com.r42914lg.core_api.CoreApi
import com.r42914lg.core_api.domain.local.usecase.GetCategoryUseCase
import com.r42914lg.core_api.domain.local.usecase.SaveCategoryUseCase
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryDetailedUseCase
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryListUseCase
import com.r42914lg.feature_details.api.FeatureDetailsApi
import com.r42914lg.feature_details.di.FeatureDetailsComponentHolder
import com.r42914lg.feature_details.di.FeatureDetailsDependencies
import com.r42914lg.feature_list.api.FeatureListApi
import com.r42914lg.feature_list.di.FeatureListComponentHolder
import com.r42914lg.feature_list.di.FeatureListDependencies
import dagger.Module
import dagger.Provides

@Module
class FeaturesApiModule {

    @Provides
    fun provideFeatureListApi(featureListDependencies: FeatureListDependencies): FeatureListApi {
        FeatureListComponentHolder.init(featureListDependencies)
        return FeatureListComponentHolder.get()
    }

    @Provides
    fun provideFeatureDetailsApi(featureDetailsDependencies: FeatureDetailsDependencies): FeatureDetailsApi {
        FeatureDetailsComponentHolder.init(featureDetailsDependencies)
        return FeatureDetailsComponentHolder.get()
    }

    @Provides
    fun provideFeatureListDependencies(coreApi: CoreApi): FeatureListDependencies =
        object : FeatureListDependencies {
            override fun getCategoryListUseCase(): GetCategoryListUseCase =
                coreApi.provideGetCategoryListUseCase()

            override fun saveCategoryUseCase(): SaveCategoryUseCase =
                coreApi.provideSaveCategoryUseCase()
        }

    @Provides
    fun provideFeatureDetailsDependencies(coreApi: CoreApi): FeatureDetailsDependencies =
        object : FeatureDetailsDependencies {
            override fun getCategoryUseCase(): GetCategoryUseCase =
                coreApi.provideGetCategoryUseCase()

            override fun getCategoryDetailedUseCase(): GetCategoryDetailedUseCase =
                coreApi.provideGetCategoryDetailedUseCase()
        }
}