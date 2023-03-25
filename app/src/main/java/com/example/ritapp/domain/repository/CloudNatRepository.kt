package com.example.ritapp.domain.repository

import com.example.ritapp.domain.model.Countries
import retrofit2.Call

interface CloudNatRepository {
    fun getNationality(name: String): Call<Countries>
    fun getNationalityMultipleNames(names: List<String>): Call<List<Countries>>
}
