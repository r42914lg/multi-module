package com.r42914lg.feature_details.di

import com.r42914lg.feature_details.api.FeatureDetailsStarter
import com.r42914lg.feature_details.impl.start.FeatureDetailsStarterImpl
import dagger.Binds
import dagger.BindsInstance
import dagger.Module

@Module
internal interface FeatureDetailsModule {

    @Binds
    fun bindFeatureListStarter(
        @BindsInstance featureListStarterImpl: FeatureDetailsStarterImpl
    ): FeatureDetailsStarter
}