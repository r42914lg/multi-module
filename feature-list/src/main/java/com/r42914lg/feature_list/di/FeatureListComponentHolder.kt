package com.r42914lg.feature_list.di

import com.r42914lg.feature_list.api.FeatureListApi
import com.r42914lg.module_injector.ComponentHolder

object FeatureListComponentHolder :
    ComponentHolder<FeatureListApi, FeatureListDependencies> {
    private var componentHolder: FeatureListComponent? = null

    override fun init(dependencies: FeatureListDependencies) {
        if (componentHolder == null) {
            synchronized(FeatureListComponentHolder::class.java) {
                if (componentHolder == null) {
                    componentHolder = FeatureListComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): FeatureListApi {
        checkNotNull(componentHolder) { "Feature list component was not initialized!" }
        return componentHolder!!
    }

    override fun reset() {
        componentHolder = null
    }
}