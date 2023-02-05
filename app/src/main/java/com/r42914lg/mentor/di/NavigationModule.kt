package com.r42914lg.mentor.di

import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_list.api.FeatureListNavigationContract
import com.r42914lg.mentor.navigation.AppNavigationContract
import com.r42914lg.mentor.navigation.AppNavigationImpl
import dagger.Binds
import dagger.BindsInstance
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun bindFeatureListNavigationApi(@BindsInstance navigationImpl: AppNavigationImpl): FeatureListNavigationContract

    @Binds
    fun bindFeatureDetailsNavigationApi(@BindsInstance navigationImpl: AppNavigationImpl): FeatureDetailsNavigationContract

    @Binds
    fun bindAppNavigationApi(@BindsInstance navigationImpl: AppNavigationImpl): AppNavigationContract

}