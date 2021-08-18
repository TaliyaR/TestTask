package com.example.testtask.model.data.server

import com.example.testtask.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val candidatesApi: CandidatesApi by lazy {
        retrofit.create(CandidatesApi::class.java)
    }
}