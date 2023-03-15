package com.example.programm_for_test.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class dbCreateHelper(context: Context): SQLiteOpenHelper(context, dbName.DATABASE_NAME, null, dbName.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(dbName.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(dbName.SQL_DELETE_TABLE)
        onCreate(db)
    }

}