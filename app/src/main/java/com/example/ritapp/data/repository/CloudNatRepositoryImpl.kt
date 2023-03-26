package com.example.ritapp.data.repository

import com.example.ritapp.domain.repository.CloudNatRepository
import com.example.ritapp.data.api.RetrofitNatApi
import com.example.ritapp.domain.model.Countries
import retrofit2.Call

class CloudNatRepositoryImpl(private val retrofitNatApi: RetrofitNatApi): CloudNatRepository {
    override fun getNationality(names: List<String>): Call<List<Countries>> {
        return retrofitNatApi.getNationality(names)
    }
}