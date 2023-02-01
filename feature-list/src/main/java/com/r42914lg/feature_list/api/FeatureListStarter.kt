package com.r42914lg.feature_list.api

import androidx.fragment.app.FragmentManager

interface FeatureListStarter {
    fun start(fragmentManager: FragmentManager, fragmentContainerId: Int)
}