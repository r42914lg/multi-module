package com.r42914lg.feature_details.navigation

import android.content.Context

interface NavFeatureDetails {
    fun goBackFromDetails()
}

interface NavFeatureDetailsProvider {
    fun provideNavFeatureDetails(): NavFeatureDetails
}

object InjectNavFeatureDetailsUtils {
    fun provideNavFeatureDetails(activityContext: Context): NavFeatureDetails {
        return if (activityContext is NavFeatureDetailsProvider) {
            (activityContext as NavFeatureDetailsProvider).provideNavFeatureDetails()
        } else {
            throw IllegalStateException("Wrong app context")
        }
    }
}