package com.example.ritapp.di

import com.example.ritapp.data.api.RetrofitAPI
import com.example.ritapp.data.api.RetrofitNatApi
import com.example.ritapp.data.api.ServerAPI
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideRetrofitAPI(): RetrofitAPI {
        return ServerAPI().createInstance(UrlAPI.DOG_API).create(RetrofitAPI::class.java)
    }

    @Provides
    fun provideRetrofitNatAPI(): RetrofitNatApi {
        return ServerAPI().createInstance(UrlAPI.NAT_API).create(RetrofitNatApi::class.java)
    }
}

class UrlAPI{
    companion object{
        const val DOG_API = "https://dog.ceo"
        const val NAT_API = "https://api.nationalize.io"
        const val CUSTOM_API = "Собственный ввод API"

        val listAPI = listOf(DOG_API, NAT_API, CUSTOM_API)
    }
}