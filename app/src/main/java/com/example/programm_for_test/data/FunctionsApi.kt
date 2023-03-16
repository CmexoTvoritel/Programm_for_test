package com.example.programm_for_test.data

import com.example.programm_for_test.models.cryptoRep

class FunctionsApi(crypto: cryptoRep) {
    private val namesOfCrypto = arrayListOf<String>("btc", "eth", "usdt", "bnb", "usdc", "xrp", "ada", "matic", "doge", "steth")

    private val needRout = crypto.data.market_cap_percentage

    private val percentOfCrypto = arrayListOf<String>(
        needRout.btc.toString(), needRout.eth.toString(), needRout.usdt.toString(),
        needRout.bnb.toString(), needRout.usdc.toString(), needRout.xrp.toString(),
        needRout.ada.toString(), needRout.matic.toString(), needRout.doge.toString(),
        needRout.steth.toString()
    )

    fun getDataFromApi(): ArrayList<Pair<String, String>> {
        val infoApi = arrayListOf<Pair<String, String>>()
        for((i, elem) in namesOfCrypto.withIndex()) {
            infoApi += Pair(elem, percentOfCrypto[i])
        }
        return infoApi
    }
}