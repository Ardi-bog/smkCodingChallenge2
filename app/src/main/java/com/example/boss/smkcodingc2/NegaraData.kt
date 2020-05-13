package com.example.boss.smkcodingc2


import com.google.gson.annotations.SerializedName

data class NegaraData(
    @SerializedName("countries")
    val countries: List<Country>
)