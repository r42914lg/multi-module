package com.r42914lg.mentor.di

import com.r42914lg.feature_details.navigation.NavFeatureDetails
import com.r42914lg.feature_list.navigation.NavFeatureList
import com.r42914lg.mentor.navigation.NavApp
import com.r42914lg.mentor.navigation.NavigationImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface NavigationModule {

    @Binds
    @Singleton
    fun bindNavFeatureList(impl: NavigationImpl): NavFeatureList

    @Binds
    @Singleton
    fun bindNavFeatureDetails(impl: NavigationImpl): NavFeatureDetails

    @Binds
    @Singleton
    fun bindNavApp(impl: NavigationImpl): NavApp
}