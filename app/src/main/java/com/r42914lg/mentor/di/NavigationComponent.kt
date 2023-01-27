package com.r42914lg.mentor.di

import androidx.fragment.app.FragmentActivity
import com.r42914lg.feature_details.navigation.NavFeatureDetails
import com.r42914lg.feature_list.navigation.NavFeatureList
import com.r42914lg.mentor.navigation.NavApp
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NavigationModule::class])
@Singleton
interface NavigationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance activity: FragmentActivity): NavigationComponent
    }

    fun exposeNavFeatureDetails(): NavFeatureDetails
    fun exposeNavFeatureList(): NavFeatureList
    fun exposeNavApp(): NavApp
}