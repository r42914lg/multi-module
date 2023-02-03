package com.r42914lg.feature_list.di

import com.r42914lg.feature_list.impl.ui.ListViewModel
import com.r42914lg.feature_list.api.FeatureListApi
import dagger.Component

@Component(
    dependencies = [FeatureListDependencies::class],
    modules = [FeatureListModule::class]
)
interface FeatureListComponent : FeatureListApi {

    @Component.Factory
    interface Factory {
        fun create(featureListDependencies: FeatureListDependencies): FeatureListComponent
    }

    fun exposeVmFactory(): ListViewModel.Factory

    companion object {
        fun initAndGet(featureListDependencies: FeatureListDependencies): FeatureListComponent {
            return DaggerFeatureListComponent.factory().create(featureListDependencies)
        }
    }

}