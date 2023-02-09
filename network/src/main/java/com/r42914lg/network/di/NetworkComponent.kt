package com.r42914lg.network.di

import com.r42914lg.core_other.log
import com.r42914lg.network.api.NetworkApi
import dagger.Component

@Component(modules = [RetrofitModule::class])
abstract class NetworkComponent : NetworkApi {

    @Component.Factory
    interface Factory {
        fun create(): NetworkComponent
    }

    companion object {
        @Volatile
        private var networkComponent: NetworkComponent? = null

        fun get(): NetworkComponent {
            if (networkComponent == null) {
                synchronized(NetworkComponent::class.java) {
                    if (networkComponent == null) {
                        networkComponent = DaggerNetworkComponent
                            .factory()
                            .create()
                        log("LG: Network component CREATED")
                    }
                }
            }
            return networkComponent!!
        }
    }
}