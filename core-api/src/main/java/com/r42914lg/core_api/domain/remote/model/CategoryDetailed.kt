package com.r42914lg.core_api.domain.remote.model

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