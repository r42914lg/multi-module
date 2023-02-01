package com.r42914lg.feature_details.impl.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.r42914lg.core_api.domain.local.usecase.GetCategoryUseCase
import com.r42914lg.core_api.domain.remote.usecase.GetCategoryDetailedUseCase
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class DetailsViewModel @AssistedInject constructor(
    getCategoryUseCase: GetCategoryUseCase,
    private val getCategoryDetailedUseCase: GetCategoryDetailedUseCase
): ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(): DetailsViewModel
    }

    val categoryDetailed = MutableLiveData(-1)

    init {
        getCategoryUseCase.execute(1)?.observeForever {
            if (it != null)
                categoryDetailed.value = it.categoryId
        }
    }

    fun getDetails() =
        getCategoryDetailedUseCase.execute(categoryDetailed.value!!)
}