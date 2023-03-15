package com.example.programm_for_test.data

import android.provider.BaseColumns

object dbName: BaseColumns {
    const val TABLE_NAME = "crypto_db"
    const val COLUMN_NAME_CRYPTO = "crypto"
    const val COLUMN_NAME_PERCENT = "percent"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "crypto.db"

    const val CREATE_TABLE =
        "CREATE TABLE $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "$COLUMN_NAME_CRYPTO TEXT," +
            "$COLUMN_NAME_PERCENT REAL)"

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}