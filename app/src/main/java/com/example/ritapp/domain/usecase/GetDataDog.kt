package com.example.ritapp.domain.usecase

import com.example.ritapp.domain.repository.CloudRepository
import com.example.ritapp.domain.model.Dog
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

class GetDataDog(
    private val cloudRepository: CloudRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke():
            Call<Dog> = withContext(dispatcher){
        val item = cloudRepository.getRandomDog()
        item
    }
}