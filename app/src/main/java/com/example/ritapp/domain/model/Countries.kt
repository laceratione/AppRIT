package com.example.ritapp.domain.model

import com.example.ritapp.Country
import com.google.gson.annotations.SerializedName

data class Countries(
    @SerializedName("country") val countries: List<Country>,
    @SerializedName("name") val name: String
)
