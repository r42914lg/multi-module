package com.r42914lg.feature_details.di

import com.r42914lg.core_api.CoreApi
import com.r42914lg.core_api.domain.local.usecase.GetCategoryUseCase
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryDetailedUseCase
import com.r42914lg.feature_details.api.FeatureDetailsStarter
import com.r42914lg.feature_details.impl.start.FeatureDetailsStarterImpl
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides

@Module
internal abstract class FeatureDetailsStarterModule {

    @Binds
    abstract fun bindFeatureListStarter(
        @BindsInstance featureListStarterImpl: FeatureDetailsStarterImpl
    ): FeatureDetailsStarter

}