package com.r42914lg.feature_list.navigation

import android.content.Context

interface NavFeatureList {
    fun goBackFromList()
    fun nextAction()
}

interface NavFeatureListProvider {
    fun provideNavFeatureList(): NavFeatureList
}

object InjectNavFeatureListUtils {
    fun provideNavFeatureDetails(activityContext: Context): NavFeatureList {
        return if (activityContext is NavFeatureListProvider) {
            (activityContext as NavFeatureListProvider).provideNavFeatureList()
        } else {
            throw IllegalStateException("Wrong app context")
        }
    }
}