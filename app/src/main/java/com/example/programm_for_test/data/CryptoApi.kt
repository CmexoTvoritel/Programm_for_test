package com.example.programm_for_test.data

import com.example.programm_for_test.models.Product
import com.example.programm_for_test.models.cryptoRep
import retrofit2.http.GET

interface CryptoApi {
    @GET("api/v3/global")
    suspend fun getCrypto(): cryptoRep
}