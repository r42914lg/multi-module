package com.r42914lg.feature_details.di

import com.r42914lg.core_api.log
import com.r42914lg.feature_details.api.FeatureDetailsApi
import com.r42914lg.module_injector.ComponentHolder

object FeatureDetailsComponentHolder :
    ComponentHolder<FeatureDetailsApi, FeatureDetailsDependencies> {
    private var componentHolder: FeatureDetailsComponent? = null

    override fun init(dependencies: FeatureDetailsDependencies) {
        if (componentHolder == null) {
            synchronized(FeatureDetailsComponentHolder::class.java) {
                if (componentHolder == null) {
                    componentHolder = FeatureDetailsComponent.initAndGet(dependencies)
                    log("LG: FeatureDetailsComponent reference INITIALIZED")
                }
            }
        }
    }

    override fun get(): FeatureDetailsApi {
        checkNotNull(componentHolder) { "Feature details component was not initialized!" }
        log("LG: FeatureDetailsComponent reference RECEIVED")
        return componentHolder!!
    }

    override fun reset() {
        log("LG: FeatureDetailsComponent reference RESET")
        componentHolder = null
    }
}