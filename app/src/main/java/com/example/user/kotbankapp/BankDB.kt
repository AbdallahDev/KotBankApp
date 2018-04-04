package com.example.user.kotbankapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BankDB(context:Context) : SQLiteOpenHelper(context,"bank.db",null,1)
{
    override fun onCreate(p0: SQLiteDatabase) {
        p0.execSQL("create table users(email text,password text,name text,credit integer)")
        p0.execSQL("create table trans(email text,amount integer,dw text)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}
