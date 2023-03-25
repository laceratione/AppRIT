package com.example.ritapp.data.api

import com.example.ritapp.domain.model.Dog
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("/api/breeds/image/random")
    fun getRandomDog(): Call<Dog>

}