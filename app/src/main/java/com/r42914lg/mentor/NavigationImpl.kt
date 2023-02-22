package com.r42914lg.mentor

import android.app.Activity
import androidx.fragment.app.FragmentManager
import com.r42914lg.core_impl.di.CoreComponentHolder
import com.r42914lg.feature_details.api.FeatureDetailsApi
import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_list.api.FeatureListApi
import com.r42914lg.feature_list.api.FeatureListNavigationContract
import javax.inject.Inject
import javax.inject.Provider

class NavigationImpl @Inject constructor(
    private val activity: Activity,
    private val fragmentManager: FragmentManager,
    private val featureListApi: Provider<FeatureListApi>,
    private val featureDetailsApi: Provider<FeatureDetailsApi>,
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
        featureDetailsApi
            .get()
            .featureDetailsStarter()
            .start(fragmentManager, R.id.fragment_container)
    }

    override fun goBackFromDetails() {
        toList()
    }

    override fun proceed() {
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
        featureListApi
            .get()
            .featureListStarter()
            .start(fragmentManager, R.id.fragment_container)
    }
}
