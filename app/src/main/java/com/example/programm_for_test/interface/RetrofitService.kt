package com.example.programm_for_test.`interface`

import com.example.programm_for_test.models.MarketCapPercentage
import com.example.programm_for_test.models.cryptoRep
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitService {
    @GET("/api/v3/global")
    @Headers("Content-Type: application/json")
    fun getGlobalData(): Single<cryptoRep>
}