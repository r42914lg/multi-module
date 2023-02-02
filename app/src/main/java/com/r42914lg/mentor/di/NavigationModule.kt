package com.r42914lg.mentor.di

import androidx.fragment.app.FragmentFactory
import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_list.api.FeatureListNavigationContract
import com.r42914lg.mentor.AppFragmentFactory
import com.r42914lg.mentor.navigation.AppNavigationContract
import com.r42914lg.mentor.navigation.AppNavigationImpl
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun bindFeatureListNavigationApi(navigationImpl: AppNavigationImpl): FeatureListNavigationContract

    @Binds
    fun bindFeatureDetailsNavigationApi(navigationImpl: AppNavigationImpl): FeatureDetailsNavigationContract

    @Binds
    fun bindAppNavigationApi(navigationImpl: AppNavigationImpl): AppNavigationContract

    @Binds
    fun bindFragmentFactory(appFragmentFactory: AppFragmentFactory): FragmentFactory

}