package com.example.programm_for_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.programm_for_test.data.CryptoApi
import com.example.programm_for_test.data.FunctionsApi
import com.example.programm_for_test.data.dbManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    val dbmanager = dbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClickParse(view: View) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val cryptoApi = retrofit.create(CryptoApi::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val crypto = cryptoApi.getCrypto()
            runOnUiThread {
                val functionsApi = FunctionsApi(crypto)
                val infoFromApiCrypto = functionsApi.getDataFromApi()
                dbmanager.openDb()
                dbmanager.insertData(infoFromApiCrypto)
                info.text = "DataBase was updated successful!"
            }
        }
        cryptoItem.text = ""
        info.text = "Before click buttons, plz wait!"

    }


    fun onClickShow(view: View) {
        cryptoItem.text = ""
        info.text = "Info about crypto:"
        val dataList = dbmanager.readDbData()
        for(item in dataList) {
            cryptoItem.append("${item.first} : ${item.second}")
            cryptoItem.append("\n")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dbmanager.closeDb()
    }
}