package com.r42914lg.core_api.domain.local.model

data class CategoryDb(
    val id: Int = 1,
    val categoryId: Int
)

data class Category(
    val id: Int,
    val title: String,
    val cluesCount: Int,
)

data class CategoryDetailed(
    val id: Int,
    val title: String,
    val cluesCount: Int,
    val clues: List<Clue>)

data class Clue(
    val id: Int,
    val answer: String,
    val question: String) {

    fun asString() = String.format("Question: %s; Answer: %s \n\n", question, answer)
}