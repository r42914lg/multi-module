package com.r42914lg.core_impl.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.r42914lg.core_impl.domain.local.model.CategoryEntity

@Dao
internal interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: CategoryEntity)

    @Query("SELECT * FROM CategoryEntity WHERE id = :id")
    fun getCategoryById(id: Int) : LiveData<CategoryEntity?>?
}