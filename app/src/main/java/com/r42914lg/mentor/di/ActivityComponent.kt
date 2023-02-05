package com.r42914lg.mentor.di

import android.app.Activity
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.FragmentManager
import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.mentor.navigation.AppNavigationContract
import dagger.BindsInstance
import dagger.Component
import dagger.internal.Preconditions

@Component(
    dependencies = [AppComponent::class],
    modules = [
        FeaturesApiModule::class,
        NavigationModule::class,
        FragmentsModule::class
    ]
)
interface ActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            @BindsInstance activity: Activity,
            @BindsInstance fragmentManager: FragmentManager
        ): ActivityComponent
    }

    fun exposeAppNavigationApi(): AppNavigationContract
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