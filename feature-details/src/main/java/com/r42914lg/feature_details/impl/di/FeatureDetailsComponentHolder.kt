package com.r42914lg.feature_details.impl.di

import com.r42914lg.core_other.log
import com.r42914lg.feature_details.api.FeatureDetailsApi
import com.r42914lg.module_injector.ComponentHolder

object FeatureDetailsComponentHolder :
    ComponentHolder<FeatureDetailsApi, FeatureDetailsDependencies> {

    private var dependencies: FeatureDetailsDependencies? = null
    private var component: FeatureDetailsComponent? = null

    override fun init(_dependencies: FeatureDetailsDependencies) {
        dependencies = _dependencies
        log("LG: FeatureDetailsComponent dependencies INITIALIZED")
    }

    override fun get(): FeatureDetailsApi {
        checkNotNull(dependencies) { "Feature Details dependencies were not initialized!" }
        if (component == null) {
            synchronized(FeatureDetailsComponentHolder::class.java) {
                if (component == null) {
                    component = FeatureDetailsComponent.initAndGet(dependencies!!)
                    log("LG: Feature Details component INITIALIZED")
                }
            }
        }
        checkNotNull(component) { "Feature Details component was not initialized!" }
        log("LG: Feature Details Component reference RECEIVED")
        return component!!
    }

    override fun reset() {
        log("LG: Feature Details Component reference RESET")
        component = null
        dependencies = null
    }
}