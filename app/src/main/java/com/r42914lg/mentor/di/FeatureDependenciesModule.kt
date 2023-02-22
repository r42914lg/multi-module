package com.r42914lg.mentor.di

import com.r42914lg.core_api.CoreApi
import com.r42914lg.core_api.domain.local.usecase.GetCategoryUseCase
import com.r42914lg.core_api.domain.local.usecase.SaveCategoryUseCase
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryDetailedUseCase
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryListUseCase
import com.r42914lg.core_impl.di.CoreComponentHolder
import com.r42914lg.core_impl.di.CoreDependencies
import com.r42914lg.db.data.local.dao.CategoryDao
import com.r42914lg.feature_details.api.FeatureDetailsApi
import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_details.impl.di.FeatureDetailsComponentHolder
import com.r42914lg.feature_details.impl.di.FeatureDetailsDependencies
import com.r42914lg.feature_list.api.FeatureListApi
import com.r42914lg.feature_list.api.FeatureListNavigationContract
import com.r42914lg.feature_list.impl.di.FeatureListComponentHolder
import com.r42914lg.feature_list.impl.di.FeatureListDependencies
import com.r42914lg.network.data.remote.datasource.CategoryDataSource
import dagger.Module
import dagger.Provides

@Module
class FeatureDependenciesModule {

    @Provides
    fun provideCoreApi(coreDependencies: CoreDependencies): CoreApi {
        CoreComponentHolder.init(coreDependencies)
        return CoreComponentHolder.get()
    }

    @Provides
    fun provideCoreDependencies(
        categoryDao: CategoryDao,
        categoryDataSource: CategoryDataSource
    ): CoreDependencies =
        object : CoreDependencies {
            override fun provideDbClient() = categoryDao
            override fun provideNetworkClient() = categoryDataSource
        }

    @Provides
    fun provideListApi(featureListDependencies: FeatureListDependencies): FeatureListApi {
        FeatureListComponentHolder.init(featureListDependencies)
        return FeatureListComponentHolder.get()
    }

    @Provides
    fun provideListDependencies(
        coreApi: CoreApi,
        navigationContract: FeatureListNavigationContract
    ): FeatureListDependencies =

        object : FeatureListDependencies {
            override fun getCategoryListUseCase(): GetCategoryListUseCase =
                coreApi.provideGetCategoryListUseCase()

            override fun saveCategoryUseCase(): SaveCategoryUseCase =
                coreApi.provideSaveCategoryUseCase()

            override fun navigationContract(): FeatureListNavigationContract =
                navigationContract
        }

    @Provides
    fun provideDetailsApi(featureDetailsDependencies: FeatureDetailsDependencies): FeatureDetailsApi {
        FeatureDetailsComponentHolder.init(featureDetailsDependencies)
        return FeatureDetailsComponentHolder.get()
    }

    @Provides
    fun provideDetailsDependencies(
        coreApi: CoreApi,
        navigationContract: FeatureDetailsNavigationContract
    ): FeatureDetailsDependencies =

        object : FeatureDetailsDependencies {
            override fun getCategoryUseCase(): GetCategoryUseCase =
                coreApi.provideGetCategoryUseCase()

            override fun getCategoryDetailedUseCase(): GetCategoryDetailedUseCase =
                coreApi.provideGetCategoryDetailedUseCase()

            override fun getNavigationContract(): FeatureDetailsNavigationContract =
                navigationContract
        }
}