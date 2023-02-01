package com.r42914lg.feature_details.di

import com.r42914lg.feature_details.impl.ui.DetailsViewModel
import com.r42914lg.feature_details.api.FeatureDetailsApi
import dagger.Component

@Component(
    dependencies = [FeatureDetailsDependencies::class],
    modules = [FeatureDetailsModule::class]
)
interface FeatureDetailsComponent : FeatureDetailsApi {

    @Component.Factory
    interface Factory {
        fun create(featureDetailsDependencies: FeatureDetailsDependencies): FeatureDetailsComponent
    }

    fun exposeVmFactory(): DetailsViewModel.Factory

    companion object {
        fun initAndGet(featureDetailsDependencies: FeatureDetailsDependencies): FeatureDetailsComponent {
            return DaggerFeatureDetailsComponent.factory().create(featureDetailsDependencies)
        }
    }

}