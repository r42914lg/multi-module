package com.r42914lg.feature_details.di;

import com.r42914lg.core_api.domain.local.usecase.GetCategoryUseCase
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryDetailedUseCase
import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_details.impl.ui.DetailsViewModel
import com.r42914lg.module_injector.BaseDependencies

interface FeatureDetailsDependenciesNavigationContract : BaseDependencies, FeatureDetailsNavigationContract {
    fun getVmFactory(): DetailsViewModel.Factory
    fun getCategoryUseCase(): GetCategoryUseCase
    fun getCategoryDetailedUseCase(): GetCategoryDetailedUseCase
}
