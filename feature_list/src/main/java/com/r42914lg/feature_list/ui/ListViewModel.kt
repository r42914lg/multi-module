package com.r42914lg.feature_list.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.r42914lg.core.domain.remote.Category
import com.r42914lg.utils.Resource

class ListViewModel : ViewModel() {
    fun saveCategoryId(itemId: Int) {
        TODO("Not yet implemented")
    }

    fun getCategoryList(): LiveData<Resource<List<Category>>> {
        TODO("Not yet implemented")
    }
}