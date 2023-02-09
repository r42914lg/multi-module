package com.r42914lg.feature_list.di

import com.r42914lg.feature_list.api.FeatureListApi
import com.r42914lg.feature_list.impl.ui.ListFragment
import dagger.Component

@Component(
    dependencies = [FeatureListDependencies::class],
)
interface FeatureListComponent : FeatureListApi {

    @Component.Factory
    interface Factory {
        fun create(featureListDependencies: FeatureListDependencies): FeatureListComponent
    }

    override fun inject(listFragment: ListFragment)

    companion object {
        fun initAndGet(featureListDependencies: FeatureListDependencies): FeatureListComponent {
            return DaggerFeatureListComponent.factory().create(featureListDependencies)
        }
    }

}