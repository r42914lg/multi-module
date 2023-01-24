package com.r42914lg.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.r42914lg.core.data.local.dao.CategoryDao
import com.r42914lg.core.domain.local.model.CategoryEntity

@Database(
    entities = [CategoryEntity::class],
    version = 1
)
abstract class MyDb : RoomDatabase() {
    abstract val categoryDao: CategoryDao
}