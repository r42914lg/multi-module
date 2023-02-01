package com.r42914lg.mentor.di

import android.content.Context
import dagger.Component
import dagger.internal.Preconditions

@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(ctx: Context): AppComponent
    }

    companion object {
        @Volatile
        private var instance: AppComponent? = null

        fun get(): AppComponent {
            return Preconditions.checkNotNull(instance,
                "AppComponent is not initialized yet. Call init first.")!!
        }

        fun init(component: AppComponent) {
            require(instance == null) { "AppComponent is already initialized." }
            instance = component
        }
    }

}