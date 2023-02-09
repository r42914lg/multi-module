package com.r42914lg.network.api

import com.r42914lg.module_injector.BaseAPI
import com.r42914lg.network.data.remote.datasource.CategoryDataSource

interface NetworkApi: BaseAPI {
    fun networkClient(): CategoryDataSource
}