package com.example.a35_mostrar_datos_bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by brais on 11/01/2017.
 */

public class BDhelper extends SQLiteOpenHelper {

    //Declaración de Variables
    Context ctx;
    BDhelper ayuda;
    SQLiteDatabase db;


    //Constructor
    public BDhelper(Context context) {
        super(context, "bd_prueba", null, 1);
        ctx = context;
    }

    //********************************************************************************************//
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE usuarios(username TEXT PRIMARY KEY, password TEXT NOT NULL)");
    }

    //********************************************************************************************//
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST usuarios");
        onCreate(db);
    }

    //********************************************************************************************//
    /*Método para manipular la Base de Datos*/
    public void abrir(){
        ayuda = new BDhelper(ctx);
        db= ayuda.getWritableDatabase();
    }
    //********************************************************************************************//
    public void cerrar(){
        db.close();
    }
    //********************************************************************************************//
    /*Métodos para manipular los datos*/
    public long registrar (String pNumero) throws Exception{
        ContentValues valores = new ContentValues();
        valores.put("password",pNumero);
        return db.insert("usuarios",null,valores);
    }
    //********************************************************************************************//
    public String consultar()throws Exception{
        String datos = "";
        String [] columnas = new String []{"username","password"};
        Cursor c = db.query("usuarios",columnas,null,null,null,null,null);
        for (c.moveToFirst();c.isAfterLast();c.moveToNext()){
            datos=c.getString(c.getColumnIndex("password"))+"\n";
        }
        return datos;
    }

}
