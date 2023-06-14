package com.example.foodapprecyclerview.model

data class Food(
    val category: String,
    val categoryLabel: String,
    val foodId: String,
    val image: String,
    val knownAs: String,
    val label: String,
    val nutrients: Nutrients,
    val uri: String
)