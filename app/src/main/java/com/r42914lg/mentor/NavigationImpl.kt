package com.r42914lg.mentor

import android.app.Activity
import androidx.fragment.app.FragmentManager
import com.r42914lg.core_impl.di.CoreComponentHolder
import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_details.di.FeatureDetailsComponentHolder
import com.r42914lg.feature_details.di.FeatureDetailsDependencies
import com.r42914lg.feature_details.impl.ui.DetailsFragment
import com.r42914lg.feature_list.api.FeatureListNavigationContract
import com.r42914lg.feature_list.di.FeatureListComponentHolder
import com.r42914lg.feature_list.di.FeatureListDependencies
import com.r42914lg.feature_list.impl.ui.ListFragment
import javax.inject.Inject
import javax.inject.Provider

class NavigationImpl @Inject constructor(
    private val activity: Activity,
    private val fragmentManager: FragmentManager,
    private val featureListDependencies: Provider<FeatureListDependencies>,
    private val featureDetailsDependencies: Provider<FeatureDetailsDependencies>,
) :
    ActivityNavigationContract,
    FragmentNavigationContract,
    FeatureListNavigationContract,
    FeatureDetailsNavigationContract
{

    override fun startApp() {
        toOnboarding()
    }

    override fun goBackFromList() {
        toOnboarding()
        CoreComponentHolder.reset()
    }

    override fun nextAction() {
        FeatureDetailsComponentHolder.init(featureDetailsDependencies.get())

        fragmentManager.beginTransaction()
            .addToBackStack("details")
            .replace(R.id.fragment_container, DetailsFragment::class.java, null)
            .commit()
    }

    override fun goBackFromDetails() {
        FeatureListComponentHolder.init(featureListDependencies.get())
        toList()
    }

    override fun proceed() {
        FeatureListComponentHolder.init(featureListDependencies.get())
        toList()
    }

    override fun back() {
        activity.finish()
    }

    private fun toOnboarding() {
        fragmentManager.beginTransaction()
            .addToBackStack("onboarding")
            .replace(R.id.fragment_container, OnboardingFragment::class.java, null)
            .commit()
    }

    private fun toList() {
        fragmentManager.beginTransaction()
            .addToBackStack("list")
            .replace(R.id.fragment_container, ListFragment::class.java, null)
            .commit()
    }
}
