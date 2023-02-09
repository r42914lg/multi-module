package com.r42914lg.network.data.remote.model

data class CategoryNet(
    val id: Int,
    val title: String,
    val clues_count: Int,
)

data class CategoryDetailedNet(
    val id: Int,
    val title: String,
    val clues_count: Int,
    val clues: List<ClueNet>)

data class ClueNet(
    val id: Int,
    val answer: String,
    val question: String) {

    fun asString() = String.format("Question: %s; Answer: %s \n\n", question, answer)
}