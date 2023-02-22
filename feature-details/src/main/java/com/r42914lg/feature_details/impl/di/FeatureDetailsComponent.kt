package com.r42914lg.feature_details.impl.di

import com.r42914lg.feature_details.api.FeatureDetailsApi
import com.r42914lg.feature_details.impl.di.DaggerFeatureDetailsComponent
import com.r42914lg.feature_details.impl.ui.DetailsFragment
import dagger.Component

@Component(
    modules = [FeatureDetailsModule::class],
    dependencies = [FeatureDetailsDependencies::class],
)
interface FeatureDetailsComponent : FeatureDetailsApi {

    @Component.Factory
    interface Factory {
        fun create(featureDetailsDependencies: FeatureDetailsDependencies): FeatureDetailsComponent
    }

    fun inject(listFragment: DetailsFragment)

    companion object {
        fun initAndGet(featureDetailsDependencies: FeatureDetailsDependencies): FeatureDetailsComponent {
            return DaggerFeatureDetailsComponent.factory().create(featureDetailsDependencies)
        }
    }

}