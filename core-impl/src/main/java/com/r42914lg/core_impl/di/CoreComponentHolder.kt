package com.r42914lg.core_impl.di

import com.r42914lg.core_api.CoreApi
import com.r42914lg.module_injector.ComponentHolder

object CoreComponentHolder : ComponentHolder<CoreApi, CoreDependencies> {
    private var componentHolder: CoreComponent? = null

    override fun init(dependencies: CoreDependencies) {
        if (componentHolder == null) {
            synchronized(CoreComponentHolder::class.java) {
                if (componentHolder == null) {
                    componentHolder = CoreComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): CoreApi {
        checkNotNull(componentHolder) { "Core component was not initialized!" }
        return componentHolder!!
    }

    override fun reset() {
        componentHolder = null
    }
}