package com.r42914lg.mentor.di

import android.app.Application
import com.r42914lg.core_api.CoreApi
import com.r42914lg.core_impl.di.CoreComponentHolder
import com.r42914lg.core_impl.di.CoreDependencies
import dagger.Module
import dagger.Provides

@Module
internal class AppModule {

    @Provides
    fun provideCoreDependencies(application: Application): CoreDependencies =
        object : CoreDependencies {
            override fun provideApplication(): Application {
                return application
            }
        }

    @Provides
    fun provideCoreApi(coreDependencies: CoreDependencies): CoreApi {
        CoreComponentHolder.init(coreDependencies)
        return CoreComponentHolder.get()
    }

}