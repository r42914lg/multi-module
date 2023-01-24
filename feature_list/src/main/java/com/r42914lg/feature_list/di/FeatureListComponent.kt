package com.r42914lg.feature_list.di

import com.r42914lg.core.di.CoreComponent
import com.r42914lg.feature_list.ui.ListViewModel
import dagger.Component

@Component(dependencies = [CoreComponent::class])
interface FeatureListComponent {

    fun getVmFactory(): ListViewModel.Factory

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): FeatureListComponent
    }

}