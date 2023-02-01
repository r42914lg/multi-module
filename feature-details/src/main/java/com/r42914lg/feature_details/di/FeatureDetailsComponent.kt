package com.r42914lg.feature_details.di

import com.r42914lg.feature_details.impl.ui.DetailsViewModel
import com.r42914lg.feature_details.api.FeatureDetailsApi
import dagger.Component

@Component(dependencies = [FeatureDetailsDependenciesNavigationContract::class])
interface FeatureDetailsComponent : FeatureDetailsApi {

    fun getVmFactory(): DetailsViewModel.Factory

    @Component.Factory
    interface Factory {
        fun create(featureDetailsDependencies: FeatureDetailsDependenciesNavigationContract): FeatureDetailsComponent
    }

    companion object {
        fun initAndGet(featureDetailsDependencies: FeatureDetailsDependenciesNavigationContract): FeatureDetailsComponent {
            return DaggerFeatureDetailsComponent.factory().create(featureDetailsDependencies)
        }
    }

}