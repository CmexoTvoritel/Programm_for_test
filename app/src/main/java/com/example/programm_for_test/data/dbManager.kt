package com.example.programm_for_test.data

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class dbManager(context: Context) {
    val dbcreatehelper = dbCreateHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = dbcreatehelper.writableDatabase
    }

    fun insertData(crypto: String, percent: Double) {
        val values = ContentValues().apply {
            put(dbName.COLUMN_NAME_CRYPTO, crypto)
            put(dbName.COLUMN_NAME_PERCENT, percent)

        }
        db?.insert(dbName.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun readDbData(): MutableList<String> {
        val cryptoNameList = mutableListOf <String>()
        val cursor = db?.query(dbName.CREATE_TABLE, null, null, null, null, null, null)
        with(cursor) {
            while(this?.moveToNext()!!) {
                cryptoNameList.add(cursor?.getString(cursor.getColumnIndex(dbName.COLUMN_NAME_CRYPTO)).toString())
            }
        }

        return cryptoNameList
    }
}