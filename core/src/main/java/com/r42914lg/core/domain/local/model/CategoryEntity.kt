package com.r42914lg.core.domain.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryEntity(
    @PrimaryKey
    val id: Int = 1,
    val categoryId: Int
)