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

    fun insertData(crypto: String, percent: String) {
        val values = ContentValues().apply {
            put(dbName.COLUMN_NAME_CRYPTO, crypto)
            put(dbName.COLUMN_NAME_PERCENT, percent)

        }
        db?.insert(dbName.TABLE_NAME, null, values)
    }

    @SuppressLint("Range")
    fun readDbData(): MutableList<String> {
        val cryptoNameList = mutableListOf <String>()
        val cursor = db?.query(dbName.TABLE_NAME, null, null, null, null, null, null)
        while(cursor?.moveToNext()!!) {
                cryptoNameList.add(cursor.getString(cursor.getColumnIndex(dbName.COLUMN_NAME_CRYPTO)).toString())
        }
        cursor.close()
        return cryptoNameList
    }

    fun closeDb() {
        dbcreatehelper.close()
    }
}