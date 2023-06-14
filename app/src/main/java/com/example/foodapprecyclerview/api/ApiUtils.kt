package com.example.foodapprecyclerview.api

import com.example.foodapprecyclerview.utils.Constants.BASE_URL

class ApiUtils {
    companion object{
        fun getFoodApi():FoodApi{
            return RetrofitClient.getRetrofitClient(BASE_URL).create(FoodApi::class.java)
        }
    }
}