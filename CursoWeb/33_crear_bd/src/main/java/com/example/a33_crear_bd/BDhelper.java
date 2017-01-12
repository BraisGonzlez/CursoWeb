package com.example.a33_crear_bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by brais on 11/01/2017.
 */

public class BDhelper extends SQLiteOpenHelper {

    Context ctx;
    public BDhelper(Context context) {
        super(context, "bd_prueba", null, 1);
        ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE usuarios(username TEXT PRIMARY KEY, password TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST usuarios");
        onCreate(db);
    }
}
