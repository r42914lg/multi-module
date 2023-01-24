package com.r42914lg.feature_list.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.r42914lg.core.domain.local.model.CategoryEntity
import com.r42914lg.core.domain.local.usecase.SaveCategoryUseCase
import com.r42914lg.core.domain.remote.model.Category
import com.r42914lg.core.domain.remote.usecase.GetCategoryListUseCase
import com.r42914lg.utils.Resource
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class ListViewModel @AssistedInject constructor(
    private val getCategoryListUseCase: GetCategoryListUseCase,
    private val saveCategoryUseCase: SaveCategoryUseCase
): ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(): ListViewModel
    }

    fun saveCategoryId(itemId: Int) {
        saveCategoryUseCase.execute(CategoryEntity(categoryId = itemId))
    }

    fun getCategoryList(): LiveData<Resource<List<Category>>> {
        return getCategoryListUseCase.execute()
    }
}