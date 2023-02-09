package com.r42914lg.core_impl.di

import com.r42914lg.db.data.local.dao.CategoryDao
import com.r42914lg.module_injector.BaseDependencies
import com.r42914lg.network.data.remote.datasource.CategoryDataSource

interface CoreDependencies : BaseDependencies {
    fun provideDbClient(): CategoryDao
    fun provideNetworkClient(): CategoryDataSource
}