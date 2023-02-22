package com.r42914lg.feature_list.impl.di

import com.r42914lg.feature_list.api.FeatureListApi
import com.r42914lg.feature_list.impl.di.DaggerFeatureListComponent
import com.r42914lg.feature_list.impl.ui.ListFragment
import dagger.Component

@Component(
    modules = [FeatureListModule::class],
    dependencies = [FeatureListDependencies::class],
)
interface FeatureListComponent : FeatureListApi {

    @Component.Factory
    interface Factory {
        fun create(featureListDependencies: FeatureListDependencies): FeatureListComponent
    }

    fun inject(listFragment: ListFragment)

    companion object {
        fun initAndGet(featureListDependencies: FeatureListDependencies): FeatureListComponent {
            return DaggerFeatureListComponent.factory().create(featureListDependencies)
        }
    }

}