package com.example.programm_for_test.data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class dbManager(context: Context) {
    val dbcreatehelper = dbCreateHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = dbcreatehelper.writableDatabase
    }

    fun insertData(arrayCrypto: ArrayList<Pair<String, String>>) {
        db?.delete(dbName.TABLE_NAME, null, null)
        for (elem in arrayCrypto) {
            val values = ContentValues().apply {
                put(dbName.COLUMN_NAME_CRYPTO, elem.first)
                put(dbName.COLUMN_NAME_PERCENT, elem.second)

            }
            db?.insert(dbName.TABLE_NAME, null, values)
        }
    }

    @SuppressLint("Range")
    fun readDbData(): ArrayList<Pair<String, String>> {
        db = dbcreatehelper.readableDatabase

        val cryptoNameList = arrayListOf<Pair<String, String>>()
        val cursor = db?.query(dbName.TABLE_NAME, null, null, null, null, null, null)
        var i = 0

        while(cursor?.moveToNext()!!) {
            val dataCrypto = cursor.getString(cursor.getColumnIndex(dbName.COLUMN_NAME_CRYPTO))
            val dataPercent = cursor.getString(cursor.getColumnIndex(dbName.COLUMN_NAME_PERCENT))
            cryptoNameList += Pair(dataCrypto, dataPercent)
        }
        cursor.close()
        return cryptoNameList
    }

    fun closeDb() {
        dbcreatehelper.close()
    }
}