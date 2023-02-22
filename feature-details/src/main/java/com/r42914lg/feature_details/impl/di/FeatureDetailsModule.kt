package com.r42914lg.feature_details.impl.di

import com.r42914lg.feature_details.api.FeatureDetailsStarter
import com.r42914lg.feature_details.impl.starter.FeatureDetailsStarterImpl
import dagger.Binds
import dagger.Module

@Module
interface FeatureDetailsModule {
    @Binds
    abstract fun provideFeatureDetailsStarter(impl: FeatureDetailsStarterImpl): FeatureDetailsStarter
}