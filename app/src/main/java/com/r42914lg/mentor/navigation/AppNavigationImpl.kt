package com.r42914lg.mentor.navigation

import android.app.Activity
import androidx.fragment.app.FragmentManager
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
    private val activity: Activity,
    private val fragmentManager: FragmentManager
) : AppNavigationContract, FeatureListNavigationContract, FeatureDetailsNavigationContract {

    override fun startApp() {
        openList()
    }

    override fun goBackFromList() {
        activity.finish()
    }

    override fun nextAction() {
        featureDetails.get().featureDetailsStarter()
            .start(fragmentManager, R.id.fragment_container)
    }

    override fun goBackFromDetails() {
        openList()
    }

    private fun openList() {
        featureList.get().featureListStarter()
            .start(fragmentManager, R.id.fragment_container)
    }
}