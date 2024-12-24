package com.example.jeckpackcomposeinstagram.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitHelper {
    fun getRetroFIt(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.oi/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}