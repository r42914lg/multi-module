package com.r42914lg.feature_list.impl.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.r42914lg.core_api.domain.local.model.CategoryDb
import com.r42914lg.core_api.domain.remote.model.Category
import com.r42914lg.feature_list.di.FeatureListDependencies
import com.r42914lg.utils.Resource
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class ListViewModel @AssistedInject constructor(
    private val featureListDependencies: FeatureListDependencies,
): ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(): ListViewModel
    }

    fun saveCategoryId(itemId: Int) {
        featureListDependencies
            .saveCategoryUseCase()
            .execute(CategoryDb(categoryId = itemId))
    }

    fun getCategoryList(): LiveData<Resource<List<Category>>> {
        return featureListDependencies
            .getCategoryListUseCase()
            .execute()
    }
}