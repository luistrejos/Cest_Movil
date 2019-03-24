package com.cest.cest_mobile.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.cest.cest_mobile.Database.DatabaseSchema.*;

public class CestMovilDB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "cest_movil.db";

    private static final String SQL_CREAR_TABLA_ELEMENTO  = "create table if not exists "
            + Elemento.TABLE_NAME + "("
            + Elemento._ID + " integer primary key autoincrement, "
            + Elemento.ID + " text not null, "
            + Elemento.TIPO + " text not null, "
            + Elemento.LETRA_BLOQUE + " text not null, "
            + "unique (" + Elemento.ID + "))";

    private static final String SQL_CREAR_TABLA_EXTINTOR = "";

    public CestMovilDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREAR_TABLA_ELEMENTO);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }



}
