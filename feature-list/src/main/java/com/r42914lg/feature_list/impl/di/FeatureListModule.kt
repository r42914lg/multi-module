package com.r42914lg.feature_list.impl.di

import com.r42914lg.feature_list.api.FeatureListStarter
import com.r42914lg.feature_list.impl.starter.FeatureListStarterImpl
import dagger.Binds
import dagger.Module

@Module
interface FeatureListModule {
    @Binds
    abstract fun provideFeatureListStarter(impl: FeatureListStarterImpl): FeatureListStarter
}