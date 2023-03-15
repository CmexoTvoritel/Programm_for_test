package com.example.programm_for_test.Common

import com.example.programm_for_test.`interface`.RetrofitService
import com.example.programm_for_test.retrofit.RetrofitClient

object Common {
    private val CONST_URL = "https://api.coingecko.com/api/v3/"
    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(CONST_URL).create(RetrofitService::class.java)
}