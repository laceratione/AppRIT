package com.example.ritapp.di

import com.example.ritapp.data.api.RetrofitAPI
import com.example.ritapp.data.api.RetrofitNatApi
import com.example.ritapp.data.repository.CloudNatRepositoryImpl
import com.example.ritapp.data.repository.CloudRepositoryImpl
import com.example.ritapp.domain.repository.CloudNatRepository
import com.example.ritapp.domain.repository.CloudRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideCloudRepositoryImpl(retrofitAPI: RetrofitAPI): CloudRepository {
        return CloudRepositoryImpl(retrofitAPI)
    }

    @Provides
    fun provideCloudNatRepositoryImpl(retrofitNatApi: RetrofitNatApi): CloudNatRepository {
        return CloudNatRepositoryImpl(retrofitNatApi)
    }
}