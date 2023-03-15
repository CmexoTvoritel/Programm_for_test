package com.example.programm_for_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.programm_for_test.data.dbManager
import com.example.programm_for_test.models.MarketCapPercentage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val dbmanager = dbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickParse(view: View) {
        dbmanager.openDb()
        dbmanager.insertData("eph", 0.00)
    }


    fun onClickShow(view: View) {
        infoCrypto.text = ""
        val dataList = dbmanager.readDbData()
        infoCrypto.append(dataList.size.toString())
        var i = 0
        for(item in dataList) {
            infoCrypto.append("$item +  $i")
            i++
            infoCrypto.append("\n")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dbmanager.closeDb()
    }
}