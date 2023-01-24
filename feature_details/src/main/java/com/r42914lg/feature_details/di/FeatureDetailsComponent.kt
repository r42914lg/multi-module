package com.r42914lg.feature_details.di

import com.r42914lg.core.di.CoreComponent
import com.r42914lg.feature_details.ui.DetailsViewModel
import dagger.Component

@Component(dependencies = [CoreComponent::class])
interface FeatureDetailsComponent {

    fun getVmFactory(): DetailsViewModel.Factory

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): FeatureDetailsComponent
    }

}