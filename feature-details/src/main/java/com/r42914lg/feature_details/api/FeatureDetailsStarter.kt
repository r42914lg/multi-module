package com.r42914lg.feature_details.api

import androidx.fragment.app.FragmentManager

interface FeatureDetailsStarter {
    fun start(fragmentManager: FragmentManager, fragmentContainerId: Int)
}