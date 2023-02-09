package com.r42914lg.feature_details.api

import com.r42914lg.feature_details.impl.ui.DetailsFragment
import com.r42914lg.module_injector.BaseAPI

interface FeatureDetailsApi : BaseAPI {
    fun inject(detailsFragment: DetailsFragment)
}