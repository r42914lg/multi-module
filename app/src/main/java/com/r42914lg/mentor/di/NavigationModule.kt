package com.r42914lg.mentor.di

import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_list.api.FeatureListNavigationContract
import com.r42914lg.mentor.ActivityNavigationContract
import com.r42914lg.mentor.FragmentNavigationContract
import com.r42914lg.mentor.NavigationImpl
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun bindAppNavigation(navigationImpl: NavigationImpl): ActivityNavigationContract

    @Binds
    fun bindFeatureListNavContract(impl: NavigationImpl): FeatureListNavigationContract

    @Binds
    fun bindFeatureDetailsNavContract(impl: NavigationImpl): FeatureDetailsNavigationContract

    @Binds
    fun bindFragmentNavContract(impl: NavigationImpl): FragmentNavigationContract
}