package com.example.visitiproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "VisitiDB";
    public static final String TABLE_FOR_LOGIN = "table_for_login";

    public static final String ID = "ID";
    //public static final String Username = "Username";
    public static final String Email = "Email";
//    public static final String Password = "Password";
//    public static final String Salt = "Salt";
//    public static final String RegistrationDate = "Registration";
//    public static final String UserRight = "Rights";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_FOR_LOGIN + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Email + " VARCHAR(25)" +
                ");");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOR_LOGIN);
        onCreate(db);
    }


}
