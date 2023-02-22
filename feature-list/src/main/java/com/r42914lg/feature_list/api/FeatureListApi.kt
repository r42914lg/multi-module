package com.r42914lg.feature_list.api

import com.r42914lg.module_injector.BaseAPI

interface FeatureListApi : BaseAPI {
    fun featureListStarter(): FeatureListStarter
}