package com.example.baitap_22_4_insert_select_update_delete_and_display_data_in_listview

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class myHelper(context: Context) :SQLiteOpenHelper(context,"TUHOCDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        // tạo table
        db?.execSQL("Create table TUHOC(id integer primary key autoincrement, user TEXT,email TEXT)")
        // them co so du lieu
        db?.execSQL("insert into TUHOC(user,email)values ('mot','mot@gmail.com')")
        db?.execSQL("insert into TUHOC(user,email)values ('hai','hai@gmail.com')")
        db?.execSQL("insert into TUHOC(user,email)values ('ba','ba@gmail.com')")
        db?.execSQL("insert into TUHOC(user,email)values ('tuhoc','tuhoc.cc@gmail.com')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}