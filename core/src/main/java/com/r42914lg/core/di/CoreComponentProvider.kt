package com.r42914lg.core.di

import android.content.Context

interface CoreComponentProvider {
    fun provideCoreComponent(): CoreComponent
}

object InjectUtils {
    fun provideCoreComponent(applicationContext: Context): CoreComponent {
        return if (applicationContext is CoreComponentProvider) {
            (applicationContext as CoreComponentProvider).provideCoreComponent()
        } else {
            throw IllegalStateException("Wrong app context")
        }
    }
}