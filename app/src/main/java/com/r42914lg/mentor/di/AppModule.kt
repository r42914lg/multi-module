package com.r42914lg.mentor.di

import android.app.Application
import com.r42914lg.db.data.local.dao.CategoryDao
import com.r42914lg.db.di.DbComponent
import com.r42914lg.network.data.remote.datasource.CategoryDataSource
import com.r42914lg.network.di.NetworkComponent
import dagger.Module
import dagger.Provides

@Module
internal class AppModule {

    @Provides
    fun provideDbClient(application: Application): CategoryDao =
        DbComponent.initAndGet(application).dbClient()

    @Provides
    fun provideNetworkClient(): CategoryDataSource =
                NetworkComponent.get().networkClient()
}