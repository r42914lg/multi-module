package com.r42914lg.db.di

import android.app.Application
import androidx.room.Room
import com.r42914lg.db.data.local.MyDb
import com.r42914lg.db.data.local.dao.CategoryDao
import dagger.Module
import dagger.Provides

@Module
internal class RoomModule {

    @Provides
    fun getRoomDao(app: Application) : CategoryDao =
        Room.databaseBuilder(app, MyDb::class.java, "my_db")
            .build()
            .categoryDao

}