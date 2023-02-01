package com.r42914lg.core_impl.di

import com.r42914lg.core_api.CoreApi
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [CoreDependencies::class],
    modules = [RetrofitModule::class, RoomModule::class]
)
@Singleton
internal interface CoreComponent : CoreApi {

    @Component.Factory
    interface Factory {
        fun create(coreDependencies: CoreDependencies): CoreComponent
    }

    companion object {
        fun initAndGet(coreDependencies: CoreDependencies): CoreComponent {
            return DaggerCoreComponent.factory().create(coreDependencies)
        }
    }
}