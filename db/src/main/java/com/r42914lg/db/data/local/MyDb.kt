package com.r42914lg.db.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.r42914lg.db.data.local.dao.CategoryDao
import com.r42914lg.db.data.local.model.CategoryEntity

@Database(
    entities = [CategoryEntity::class],
    version = 1
)
internal abstract class MyDb : RoomDatabase() {
    abstract val categoryDao: CategoryDao
}