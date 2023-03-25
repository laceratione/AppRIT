package com.example.ritapp.data.repository

import com.example.ritapp.domain.repository.CloudNatRepository
import com.example.ritapp.data.api.RetrofitNatApi
import com.example.ritapp.domain.model.Countries
import retrofit2.Call

class CloudNatRepositoryImpl(private val retrofitNatApi: RetrofitNatApi): CloudNatRepository {
    override fun getNationality(name: String): Call<Countries> {
        return retrofitNatApi.getNationality(name)
    }

    override fun getNationalityMultipleNames(names: List<String>): Call<List<Countries>> {
        return retrofitNatApi.getNationalityMultipleNames(names)
    }
}