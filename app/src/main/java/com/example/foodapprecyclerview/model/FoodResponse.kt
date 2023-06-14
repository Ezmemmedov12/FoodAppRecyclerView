package com.example.foodapprecyclerview.model

data class FoodResponse(
    val _links: Links,
    val hints: List<Hint>,
    val parsed: List<Any>,
    val text: String
)