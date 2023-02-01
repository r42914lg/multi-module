package com.r42914lg.core_impl.di

import android.app.Application
import androidx.room.Room
import com.r42914lg.core_impl.data.local.MyDb
import com.r42914lg.core_impl.data.local.dao.CategoryDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class RoomModule {

    @Provides
    @Singleton
    fun getRoomDao(app: Application) : CategoryDao =
        Room.databaseBuilder(app, MyDb::class.java, "my_db")
            .build()
            .categoryDao

}