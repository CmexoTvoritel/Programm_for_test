package com.example.programm_for_test.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if(retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl("https://api.coingecko.com")
                .addConverterFactory(GsonConverterFactory.create()).
                build()
        }
        return retrofit!!
    }
}