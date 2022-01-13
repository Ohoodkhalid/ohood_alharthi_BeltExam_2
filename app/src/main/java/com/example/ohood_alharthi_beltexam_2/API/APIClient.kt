package com.example.ohood_alharthi_beltexam_2.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    private var retrofit : Retrofit? = null
    fun getClient(): Retrofit?{
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.tvmaze.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }
}