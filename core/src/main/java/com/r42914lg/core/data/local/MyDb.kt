package com.r42914lg.core.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.r42914lg.core.data.local.dao.CategoryDao
import com.r42914lg.core.domain.local.model.CategoryEntity

@Database(
    entities = [CategoryEntity::class],
    version = 1
)
abstract class MyDb : RoomDatabase() {

    abstract fun CategoryDao(): CategoryDao

    companion object {
        @Volatile private var INSTANCE: MyDb? = null

        fun getDatabase(context: Context) : MyDb =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, MyDb::class.java, "mydb")
                .fallbackToDestructiveMigration()
                .build()
    }
}