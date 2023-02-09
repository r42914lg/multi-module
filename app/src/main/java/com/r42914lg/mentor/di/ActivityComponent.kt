package com.r42914lg.mentor.di

import android.app.Activity
import androidx.fragment.app.FragmentManager
import com.r42914lg.core_other.log
import com.r42914lg.feature_details.di.FeatureDetailsDependencies
import com.r42914lg.feature_list.di.FeatureListDependencies
import com.r42914lg.mentor.MainActivity
import com.r42914lg.mentor.OnboardingFragment
import dagger.BindsInstance
import dagger.Component
import dagger.internal.Preconditions

@Component(dependencies = [AppComponent::class],
    modules = [
        NavigationModule::class,
        FeatureDependenciesModule::class
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

    fun inject(mainActivity: MainActivity)
    fun inject(onboardingFragment: OnboardingFragment)

    fun exposeFeatureListDependencies(): FeatureListDependencies
    fun exposeFeatureDetailsDependencies(): FeatureDetailsDependencies

    companion object {
        @Volatile
        private var instance: ActivityComponent? = null

        fun get(): ActivityComponent {
            return Preconditions.checkNotNull(instance,
                "ActivityComponent is not initialized yet. Call init first.")!!
        }

        fun init(component: ActivityComponent) {
            require(instance == null) { "ActivityComponent is already initialized." }
            log("LG: Activity component CREATED")
            instance = component
        }
    }
}