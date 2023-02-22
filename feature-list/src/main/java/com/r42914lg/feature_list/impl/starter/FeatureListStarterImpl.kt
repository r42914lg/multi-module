package com.r42914lg.feature_list.impl.starter

import androidx.fragment.app.FragmentManager
import com.r42914lg.feature_list.api.FeatureListStarter
import com.r42914lg.feature_list.impl.ui.ListFragment
import javax.inject.Inject

class FeatureListStarterImpl @Inject constructor() : FeatureListStarter {
    override fun start(fragmentManager: FragmentManager, containerId: Int) {
        fragmentManager.beginTransaction()
            .addToBackStack("list")
            .replace(containerId, ListFragment::class.java, null)
            .commit()
    }
}