package com.example.ritapp.data.repository

import com.example.ritapp.domain.repository.CloudRepository
import com.example.ritapp.domain.model.Dog
import com.example.ritapp.data.api.RetrofitAPI
import retrofit2.Call

class CloudRepositoryImpl(private val retrofitAPI: RetrofitAPI): CloudRepository {
    override fun getRandomDog(): Call<Dog> {
        return retrofitAPI.getRandomDog()
    }
}