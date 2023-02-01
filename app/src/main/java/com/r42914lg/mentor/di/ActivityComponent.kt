package com.r42914lg.mentor.di

import androidx.fragment.app.FragmentActivity
import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_list.api.FeatureListNavigationContract
import com.r42914lg.mentor.navigation.AppNavigationContract
import dagger.BindsInstance
import dagger.Component
import dagger.internal.Preconditions

@Component(
    dependencies = [AppComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            @BindsInstance fragmentActivity: FragmentActivity
        ): ActivityComponent
    }

    fun exposeFeatureListNavigationApi(): FeatureListNavigationContract
    fun exposeFeatureDetailsNavigationApi(): FeatureDetailsNavigationContract
    fun exposeAppNavigationApi(): AppNavigationContract

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