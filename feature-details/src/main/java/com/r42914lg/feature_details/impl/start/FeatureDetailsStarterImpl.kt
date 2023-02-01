package com.r42914lg.feature_details.impl.start

import androidx.fragment.app.FragmentManager
import com.r42914lg.feature_details.api.FeatureDetailsStarter
import com.r42914lg.feature_details.impl.ui.DetailsFragment
import javax.inject.Inject

internal class FeatureDetailsStarterImpl @Inject constructor() : FeatureDetailsStarter {
    override fun start(fragmentManager: FragmentManager, fragmentContainerId: Int) {
        fragmentManager.beginTransaction()
            .addToBackStack("details")
            .replace(fragmentContainerId, DetailsFragment::class.java, null)
            .commit()
    }
}