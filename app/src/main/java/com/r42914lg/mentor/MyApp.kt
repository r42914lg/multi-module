package com.r42914lg.mentor

import android.app.Application
import com.r42914lg.core.di.CoreComponent
import com.r42914lg.core.di.CoreComponentProvider
import com.r42914lg.core.di.DaggerCoreComponent

class MyApp : Application(), CoreComponentProvider {
    private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()

        coreComponent = DaggerCoreComponent.factory().create(this)
    }

    override fun provideCoreComponent(): CoreComponent {
        return coreComponent
    }
}