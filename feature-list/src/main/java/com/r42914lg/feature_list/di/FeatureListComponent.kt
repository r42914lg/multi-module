package com.r42914lg.feature_list.di

import com.r42914lg.feature_list.impl.ui.ListViewModel
import com.r42914lg.feature_list.api.FeatureListApi
import dagger.Component

@Component(dependencies = [FeatureListDependencies::class])
interface FeatureListComponent : FeatureListApi {

    fun getVmFactory(): ListViewModel.Factory

    @Component.Factory
    interface Factory {
        fun create(featureListDependencies: FeatureListDependencies): FeatureListComponent
    }

    companion object {
        fun initAndGet(featureListDependencies: FeatureListDependencies): FeatureListComponent {
            return DaggerFeatureListComponent.factory().create(featureListDependencies)
        }
    }

}