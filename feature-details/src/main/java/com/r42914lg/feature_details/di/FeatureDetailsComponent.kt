package com.r42914lg.feature_details.di

import com.r42914lg.feature_details.impl.ui.DetailsViewModel
import com.r42914lg.feature_details.api.FeatureDetailsApi
import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_details.impl.ui.DetailsFragment
import dagger.Component

@Component(
    dependencies = [FeatureDetailsDependencies::class],
)
interface FeatureDetailsComponent : FeatureDetailsApi {

    @Component.Factory
    interface Factory {
        fun create(featureDetailsDependencies: FeatureDetailsDependencies): FeatureDetailsComponent
    }

    override fun inject(listFragment: DetailsFragment)

    companion object {
        fun initAndGet(featureDetailsDependencies: FeatureDetailsDependencies): FeatureDetailsComponent {
            return DaggerFeatureDetailsComponent.factory().create(featureDetailsDependencies)
        }
    }

}