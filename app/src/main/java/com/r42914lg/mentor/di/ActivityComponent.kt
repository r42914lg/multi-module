package com.r42914lg.mentor.di

import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import com.r42914lg.feature_list.di.FeatureListDependencies
import dagger.BindsInstance
import dagger.Component
import dagger.internal.Preconditions

@Component(
    dependencies = [AppComponent::class],
    modules = [
        FeatureApiAndDependenciesModule::class,
        FragmentsModule::class
    ]
)
interface ActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            @BindsInstance fragmentManager: FragmentManager
        ): ActivityComponent
    }

    fun exposeFragmentFactory(): FragmentFactory

    companion object {
        @Volatile
        private var instance: ActivityComponent? = null

        fun get(): ActivityComponent {
            return Preconditions.checkNotNull(instance,
                "ActivityComponent is not initialized yet. Call init first.")!!
        }

        fun init(component: ActivityComponent) {
            require(instance == null) { "ActivityComponent is already initialized." }
            instance = component
        }
    }
}