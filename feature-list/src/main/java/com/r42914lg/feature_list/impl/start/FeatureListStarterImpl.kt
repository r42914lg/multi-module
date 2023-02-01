package com.r42914lg.feature_list.impl.start

import androidx.fragment.app.FragmentManager
import com.r42914lg.feature_list.api.FeatureListStarter
import com.r42914lg.feature_list.impl.ui.ListFragment
import javax.inject.Inject

internal class FeatureListStarterImpl @Inject constructor() : FeatureListStarter {
    override fun start(fragmentManager: FragmentManager, fragmentContainerId: Int) {
        fragmentManager.beginTransaction()
            .addToBackStack("list")
            .replace(fragmentContainerId, ListFragment::class.java, null)
            .commit()
    }
}