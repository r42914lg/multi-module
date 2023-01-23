package com.r42914lg.feature_details.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.r42914lg.core.domain.remote.CategoryDetailed
import com.r42914lg.utils.Resource

class DetailsViewModel : ViewModel() {

    private fun getCategoryId(): Int {
        TODO("Not yet implemented")
    }

    fun getDetails(): LiveData<Resource<CategoryDetailed>> {
        TODO("Not yet implemented")
    }
}