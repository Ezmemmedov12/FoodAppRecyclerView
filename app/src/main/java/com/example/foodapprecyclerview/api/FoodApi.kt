package com.example.foodapprecyclerview.api


import com.example.foodapprecyclerview.model.FoodResponse
import com.example.foodapprecyclerview.model.Hint
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface FoodApi {
    @GET("parser")
    @Headers("X-RapidAPI-Key: 322420b87cmshd33dfe65664970ep134867jsne09b0b23c923","X-RapidAPI-Host: edamam-food-and-grocery-database.p.rapidapi.com")
    fun getAllFood(): Call<Hint>
}