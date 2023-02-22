package com.r42914lg.feature_details.impl.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.r42914lg.feature_details.impl.di.FeatureDetailsDependencies
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class DetailsViewModel @AssistedInject constructor(
    private val featureDetailsDependencies: FeatureDetailsDependencies,
): ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(): DetailsViewModel
    }

    val categoryDetailed = MutableLiveData(-1)

    init {
        featureDetailsDependencies
            .getCategoryUseCase()
            .execute(1)?.observeForever {
                if (it != null)
                    categoryDetailed.value = it.categoryId
            }
    }

    fun getDetails() =
        featureDetailsDependencies
            .getCategoryDetailedUseCase()
            .execute(categoryDetailed.value!!)
}