package com.r42914lg.feature_details.di

import com.r42914lg.feature_details.api.FeatureDetailsApi
import com.r42914lg.module_injector.ComponentHolder

object FeatureDetailsComponentHolder :
    ComponentHolder<FeatureDetailsApi, FeatureDetailsDependenciesNavigationContract> {
    private var componentHolder: FeatureDetailsComponent? = null

    override fun init(dependencies: FeatureDetailsDependenciesNavigationContract) {
        if (componentHolder == null) {
            synchronized(FeatureDetailsComponentHolder::class.java) {
                if (componentHolder == null) {
                    componentHolder = FeatureDetailsComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): FeatureDetailsApi {
        checkNotNull(componentHolder) { "Feature details component was not initialized!" }
        return componentHolder!!
    }

    override fun reset() {
        componentHolder = null
    }
}