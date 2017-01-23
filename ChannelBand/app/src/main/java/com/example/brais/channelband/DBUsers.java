package com.example.brais.channelband;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by brais on 23/01/2017.
 */

public class DBUsers extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "users.db";
    public static final String TABLE_NAME = "users_table";
    public static final String NAME = "NAME";
    public static final String INSTRUMENT = "INSTRUMENT";
    public static final String BAND = "BAND";
    public static final String OLDBAND = "OLDBAND";


    public DBUsers(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create a new database
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (NAME TEXT PRIMARY KEY, INSTRUMENT TEXT, BAND TEXT, OLDBAND TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Delete the old version of our database
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        //Create a new database
        onCreate(db);
    }

    public boolean insertData(String name,String instrument,String band, String oldband) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("NAME",name);
        contentValues.put("INSTRUMENT",instrument);
        contentValues.put("BAND",band);
        contentValues.put("OLDBAND",oldband);

        long result = db.insert(TABLE_NAME ,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String name,String instrument,String band,String oldband) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("INSTRUMENT",instrument);
        contentValues.put("BAND",band);
        contentValues.put("OLDBAND",oldband);
        db.update(TABLE_NAME, contentValues, "NAME = ?",new String[] { name });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "NAME = ?",new String[] {id});
    }
}