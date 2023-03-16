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

    fun insertData(crypto: String, percent: Double) {
        db?.delete(dbName.TABLE_NAME, null, null)

        val values = ContentValues().apply {
            put(dbName.COLUMN_NAME_CRYPTO, crypto)
            put(dbName.COLUMN_NAME_PERCENT, percent)

        }
        db?.insert(dbName.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun readDbData(): MutableList<String> {
        db = dbcreatehelper.readableDatabase

        val cryptoNameList = mutableListOf<String>()
        val cursor = db?.query(dbName.TABLE_NAME, null, null, null, null, null, null)

        while(cursor?.moveToNext()!!) {
            val dataCrypto = cursor.getString(cursor.getColumnIndex(dbName.COLUMN_NAME_CRYPTO))
            val dataPercent = cursor.getString(cursor.getColumnIndex(dbName.COLUMN_NAME_PERCENT))
            cryptoNameList.add(dataCrypto.toString())
            cryptoNameList.add(dataPercent.toString())
        }
        cursor.close()
        return cryptoNameList
    }

    fun closeDb() {
        dbcreatehelper.close()
    }
}