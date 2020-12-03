package com.malkinfo.registerandlogin.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper (c:Context):
        SQLiteOpenHelper(c,"USERMAIL",null,1)
{
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(USERID INTEGER PRIMARY KEY AUTOINCREMENT, UNAME TEXT , PASS TEXT)")
        db?.execSQL("INSERT INTO USERS(UNAME , PASS) VALUES('fairda@gmail.com','saz')")
        db?.execSQL("INSERT INTO USERS(UNAME , PASS) VALUES('zoya@gmail.com','saz')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}
