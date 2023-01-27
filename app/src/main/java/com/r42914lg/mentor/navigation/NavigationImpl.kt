package com.r42914lg.mentor.navigation

import androidx.fragment.app.FragmentActivity
import com.r42914lg.feature_details.navigation.NavFeatureDetails
import com.r42914lg.feature_details.ui.DetailsFragment
import com.r42914lg.feature_list.navigation.NavFeatureList
import com.r42914lg.feature_list.ui.ListFragment
import com.r42914lg.mentor.R
import javax.inject.Inject

class NavigationImpl @Inject constructor(
    private val activity: FragmentActivity,
) : NavFeatureList, NavFeatureDetails, NavApp {

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

    override fun toStart() {
        activity.supportFragmentManager.beginTransaction()
            .addToBackStack("list")
            .replace(R.id.fragment_container, ListFragment::class.java, null)
            .commit()
    }
}