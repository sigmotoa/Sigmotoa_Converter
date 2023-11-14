package com.sigmotoa.sigmotoaconverter.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ResultInstance {
    private const val BASE_URL = "https://networkcalc.com/api/binary/"

    val apiService: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}