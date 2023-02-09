package com.r42914lg.feature_list.di

import com.r42914lg.core_other.log
import com.r42914lg.feature_list.api.FeatureListApi
import com.r42914lg.module_injector.ComponentHolder

object FeatureListComponentHolder :
    ComponentHolder<FeatureListApi, FeatureListDependencies> {

    private var dependencies: FeatureListDependencies? = null
    private var component: FeatureListComponent? = null

    override fun init(_dependencies: FeatureListDependencies) {
        dependencies = _dependencies
        log("LG: FeatureListComponent dependencies INITIALIZED")
    }

    override fun get(): FeatureListApi {
        checkNotNull(dependencies) { "Feature list dependencies were not initialized!" }
        if (component == null) {
            synchronized(FeatureListComponentHolder::class.java) {
                if (component == null) {
                    component = FeatureListComponent.initAndGet(dependencies!!)
                    log("LG: Feature list component INITIALIZED")
                }
            }
        }
        checkNotNull(component) { "Feature list component was not initialized!" }
        log("LG: FeatureListComponent reference RECEIVED")
        return component!!
    }

    override fun reset() {
        log("LG: FeatureListComponent reference RESET")
        component = null
        dependencies = null
    }
}