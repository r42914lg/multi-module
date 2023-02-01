package com.r42914lg.mentor.navigation

import androidx.fragment.app.FragmentActivity
import com.r42914lg.feature_details.api.FeatureDetailsApi
import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_list.api.FeatureListApi
import com.r42914lg.feature_list.api.FeatureListNavigationContract
import com.r42914lg.mentor.R
import javax.inject.Inject
import javax.inject.Provider

class AppNavigationImpl @Inject constructor(
    private val featureList: Provider<FeatureListApi>,
    private val featureDetails: Provider<FeatureDetailsApi>,
    private val fragmentActivity: FragmentActivity
) : AppNavigationContract, FeatureListNavigationContract, FeatureDetailsNavigationContract {

    override fun startApp() {
        openList()
    }

    override fun goBackFromList() {
        fragmentActivity.finish()
    }

    override fun nextAction() {
        featureDetails.get().featureDetailsStarter()
            .start(fragmentActivity.supportFragmentManager, R.id.fragment_container)
    }

    override fun goBackFromDetails() {
        openList()
    }

    private fun openList() {
        featureList.get().featureListStarter()
            .start(fragmentActivity.supportFragmentManager, R.id.fragment_container)
    }
}