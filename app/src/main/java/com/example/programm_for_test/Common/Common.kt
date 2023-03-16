package com.example.programm_for_test.Common

import com.example.programm_for_test.`interface`.RetrofitService
import com.example.programm_for_test.retrofit.RetrofitClient

object Common {
    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient().create(RetrofitService::class.java)
}