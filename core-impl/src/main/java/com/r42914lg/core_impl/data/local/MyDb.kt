package com.r42914lg.core_impl.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.r42914lg.core_impl.data.local.dao.CategoryDao
import com.r42914lg.core_impl.domain.local.model.CategoryEntity

@Database(
    entities = [CategoryEntity::class],
    version = 1
)
internal abstract class MyDb : RoomDatabase() {
    abstract val categoryDao: CategoryDao
}