package com.r42914lg.mentor.di

import android.app.Application
import com.r42914lg.core_impl.di.CoreDependencies
import com.r42914lg.db.data.local.dao.CategoryDao
import com.r42914lg.db.di.DbComponent
import com.r42914lg.network.data.remote.datasource.CategoryDataSource
import com.r42914lg.network.di.NetworkComponent
import dagger.Module
import dagger.Provides

@Module
internal class AppModule {

    @Provides
    fun provideCoreDependencies(application: Application): CoreDependencies =
        object : CoreDependencies {
            override fun provideDbClient(): CategoryDao =
                DbComponent.initAndGet(application).dbClient()

            override fun provideNetworkClient(): CategoryDataSource =
                NetworkComponent.get().networkClient()
        }
}