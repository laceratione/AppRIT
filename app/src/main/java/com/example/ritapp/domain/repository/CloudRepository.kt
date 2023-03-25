package com.example.ritapp.domain.repository

import com.example.ritapp.domain.model.Dog
import retrofit2.Call

interface CloudRepository {
    fun getRandomDog(): Call<Dog>
}