package com.r42914lg.db.di

import android.app.Application
import com.r42914lg.core_other.log
import com.r42914lg.db.api.DbApi
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [RoomModule::class]
)
abstract class DbComponent : DbApi {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): DbComponent
    }

    companion object {
        @Volatile
        private var coreDbComponent: DbComponent? = null

        fun initAndGet(application: Application): DbComponent {
            if (coreDbComponent == null) {
                synchronized(DbComponent::class.java) {
                    if (coreDbComponent == null) {
                        coreDbComponent = DaggerDbComponent
                            .factory()
                            .create(application)
                        log("LG: DB component CREATED")
                    }
                }
            }
            return coreDbComponent!!
        }
    }
}