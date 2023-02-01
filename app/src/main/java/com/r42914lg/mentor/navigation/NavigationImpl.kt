package com.r42914lg.mentor.navigation

import androidx.fragment.app.FragmentActivity
import com.r42914lg.feature_details.api.FeatureDetailsNavigationContract
import com.r42914lg.feature_details.impl.ui.DetailsFragment
import com.r42914lg.feature_list.api.FeatureListNavigationContract
import com.r42914lg.mentor.R
import javax.inject.Inject

interface NavigationApi : FeatureListNavigationContract, FeatureDetailsNavigationContract

class NavigationImpl @Inject constructor(
    private val activity: FragmentActivity,
) : NavigationApi {

    override fun goBackFromList() {
        activity.finish()
    }

    override fun nextAction() {
        activity.supportFragmentManager.beginTransaction()
            .addToBackStack("details")
            .replace(R.id.fragment_container, DetailsFragment::class.java, null)
            .commit()
    }

    override fun goBackFromDetails() {
        activity.supportFragmentManager.popBackStack()
    }

}