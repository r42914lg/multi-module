package com.r42914lg.core_impl.data.remote.repository

import androidx.lifecycle.liveData
import com.r42914lg.core_api.domain.local.model.Category
import com.r42914lg.core_api.domain.local.model.CategoryDetailed
import com.r42914lg.core_api.domain.local.model.Clue
import com.r42914lg.network.data.remote.datasource.CategoryDataSource
import com.r42914lg.network.data.remote.model.CategoryDetailedNet
import com.r42914lg.network.data.remote.model.CategoryNet
import com.r42914lg.network.data.remote.model.ClueNet
import com.r42914lg.utils.Resource
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

internal class CategoryRepository @Inject constructor(
    private val categoryDataSource: CategoryDataSource
    ) {

    fun getCategoryList() = liveData(Dispatchers.IO) {
        val res = categoryDataSource.getCategoryList()
        emit(Resource(res.status, res.data?.toCategoryList(), res.message))
    }

    fun getCategoryDetails(categoryId: Int) = liveData(Dispatchers.IO) {
        val res = categoryDataSource.getDetails(categoryId)
        emit(Resource(res.status, res.data?.toCategoryDetailed(), res.message))
    }
}

fun List<CategoryNet>.toCategoryList(): List<Category> {
    return this.map {
        Category(
            id = it.id,
            title = it.title,
            cluesCount = it.clues_count
        )
    }
}

fun List<ClueNet>.toClueList(): List<Clue> {
    return this.map {
        Clue(
            id = it.id,
            answer = it.answer,
            question = it.question
        )
    }
}

fun CategoryDetailedNet.toCategoryDetailed() = CategoryDetailed(
        id = this.id,
        title = this.title,
        cluesCount = this.clues_count,
        clues = this.clues.toClueList()
    )

