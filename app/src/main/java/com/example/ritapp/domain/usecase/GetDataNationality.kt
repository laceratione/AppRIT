package com.example.ritapp.domain.usecase

import com.example.ritapp.domain.repository.CloudNatRepository
import com.example.ritapp.domain.model.Countries
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

class GetDataNationality (
    private val cloudNatRepository: CloudNatRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(names: List<String>):
            Call<List<Countries>> = withContext(dispatcher) {
        val item = cloudNatRepository.getNationality(names)
        item
    }
}