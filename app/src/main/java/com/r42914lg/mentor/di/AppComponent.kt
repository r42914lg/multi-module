package com.r42914lg.mentor.di

import android.app.Application
import com.r42914lg.core_impl.di.CoreDependencies
import com.r42914lg.core_other.log
import dagger.BindsInstance
import dagger.Component
import dagger.internal.Preconditions

@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun exposeCoreDependencies(): CoreDependencies

    companion object {
        @Volatile
        private var instance: AppComponent? = null

        fun get(): AppComponent {
            return Preconditions.checkNotNull(instance,
                "AppComponent is not initialized yet. Call init first.")!!
        }

        fun init(component: AppComponent) {
            require(instance == null) { "AppComponent is already initialized." }
            log("LG: App component CREATED")
            instance = component
        }
    }

}