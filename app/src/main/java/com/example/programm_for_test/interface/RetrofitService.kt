package com.example.programm_for_test.`interface`

import com.example.programm_for_test.models.MarketCapPercentage
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("global")
    fun getMarketCapPercentage(): Call<MutableList<MarketCapPercentage>>
}