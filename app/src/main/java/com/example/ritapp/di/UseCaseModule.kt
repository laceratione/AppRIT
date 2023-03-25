package com.example.ritapp.di

import com.example.ritapp.domain.repository.CloudNatRepository
import com.example.ritapp.domain.repository.CloudRepository
import com.example.ritapp.domain.usecase.GetDataDog
import com.example.ritapp.domain.usecase.GetDataNationality
import com.example.ritapp.domain.usecase.GetDataNationalityMultiple
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetDataDog(cloudRepository: CloudRepository): GetDataDog {
        return GetDataDog(cloudRepository)
    }

    @Provides
    fun provideGetDataNationality(cloudNatRepository: CloudNatRepository): GetDataNationality {
        return GetDataNationality(cloudNatRepository)
    }

    @Provides
    fun provideGetDataNationalityMultiple(cloudNatRepository: CloudNatRepository): GetDataNationalityMultiple {
        return GetDataNationalityMultiple(cloudNatRepository)
    }
}