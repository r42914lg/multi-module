package com.r42914lg.feature_list.di

import com.r42914lg.feature_list.api.FeatureListStarter
import com.r42914lg.feature_list.impl.start.FeatureListStarterImpl
import dagger.Binds
import dagger.BindsInstance
import dagger.Module

@Module
internal interface FeatureListModule {

    @Binds
    fun bindFeatureListStarter(
        @BindsInstance featureListStarterImpl: FeatureListStarterImpl
    ): FeatureListStarter
}