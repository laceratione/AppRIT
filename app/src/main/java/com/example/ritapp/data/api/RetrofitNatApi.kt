package com.example.ritapp.data.api

import com.example.ritapp.domain.model.Countries
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitNatApi {
    @GET("/")
    fun getNationality(@Query("name[]") names: List<String>): Call<List<Countries>>
}