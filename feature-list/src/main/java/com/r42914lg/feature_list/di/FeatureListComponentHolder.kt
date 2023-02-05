package com.r42914lg.feature_list.di

import com.r42914lg.core_api.log
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
                    log("LG: FeatureListComponent reference INITIALIZED")
                }
            }
        }
    }

    override fun get(): FeatureListApi {
        checkNotNull(componentHolder) { "Feature list component was not initialized!" }
        log("LG: FeatureListComponent reference RECEIVED")
        return componentHolder!!
    }

    override fun reset() {
        log("LG: FeatureListComponent reference RESET")
        componentHolder = null
    }
}