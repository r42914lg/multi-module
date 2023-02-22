package com.r42914lg.feature_details.impl.starter

import androidx.fragment.app.FragmentManager
import com.r42914lg.feature_details.api.FeatureDetailsStarter
import com.r42914lg.feature_details.impl.ui.DetailsFragment
import javax.inject.Inject

class FeatureDetailsStarterImpl @Inject constructor() : FeatureDetailsStarter {
    override fun start(fragmentManager: FragmentManager, containerId: Int) {
        fragmentManager.beginTransaction()
            .addToBackStack("details")
            .replace(containerId, DetailsFragment::class.java, null)
            .commit()
    }
}