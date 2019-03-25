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
            + Elemento.ID + " integer primary key, "
            + Elemento.TIPO + " text not null, "
            + Elemento.LETRA_BLOQUE + " text not null)";

    private static final String SQL_CREAR_TABLA_EXTINTOR = "create table if not exists "
            + Extintor.TABLE_NAME +"("
            + Extintor.ID +" integer primary key, "
            + Extintor.ID_ELEMENTO + " integer not null, "
            + Extintor.CADUCIDADANIOS + " integer not null, "
            + Extintor.ESTADO + " text not null, "
            + Extintor.FECHAULTIMARECARGA + " text not null, "
            + Extintor.FECHAVENCIMIENTO + " text not null, "
            + Extintor.TAMANIO + " text not null, "
            + "foreign key ("+Extintor.ID_ELEMENTO+") references "+Elemento.TABLE_NAME+"("+Elemento.ID+"))";

    private static final String SQL_CREAR_TABLA_CAMILLA = "create table if not exists "
            + Camilla.TABLE_NAME +"("
            + Camilla.ID +" integer primary key, "
            + Camilla.ID_ELEMENTO + " integer not null, "
            + Camilla.TIPO + " text not null, "
            + "foreign key ("+Camilla.ID_ELEMENTO+") references "+Elemento.TABLE_NAME+"("+Elemento.ID+"))";

    private static final String SQL_CREAR_TABLA_REPORTE = "create table if not exists "
            + Reporte.TABLE_NAME +"("
            + Reporte.ID +" integer primary key, "
            + Reporte.ID_ELEMENTO + " integer not null, "
            + Reporte.ENVIADO + " text not null, "
            + Reporte.DESCRIPCION + " text not null, "
            + Reporte.ARGUMENTOS + " text not null, "
            + Reporte.ESTADO + " text not null, "
            + Reporte.FECHAREPORTE + " text not null, "
            + Reporte.LEIDO + " text not null, "
            + Reporte.NOTIFICADO + " text not null, "
            + "foreign key ("+Reporte.ID_ELEMENTO+") references "+Elemento.TABLE_NAME+"("+Elemento.ID+"))";

    private static final String SQL_CREAR_TABLA_BLOQUE = "create table if not exists "
            + Bloque.TABLE_NAME +"("
            + Bloque.LETRA + " text primary key, "
            + Bloque.NOMBRE + " text not null, "
            + Bloque.ID_SEDE + " integer not null, "
            + "foreign key ("+Bloque.ID_SEDE+") references "+Sede.TABLE_NAME+"("+Sede.ID+"))";

    private static final String SQL_CREAR_TABLA_SEDE = "create table if not exists "
            + Sede.TABLE_NAME +"("
            + Sede.ID + " integer primary key, "
            + Sede.NOMBRE + " text not null)";

    private static final String SQL_CREAR_TABLA_PISO = "create table if not exists "
            + Piso.TABLE_NAME +"("
            + Piso.NUMERO + " integer primary key, "
            + Piso.LETRA_BLOQUE + " text not null, "
            + "foreign key ("+Piso.LETRA_BLOQUE+") references "+Bloque.TABLE_NAME+"("+Bloque.LETRA+"))";

    public CestMovilDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){

        db.execSQL(SQL_CREAR_TABLA_ELEMENTO);
        db.execSQL(SQL_CREAR_TABLA_EXTINTOR);
        db.execSQL(SQL_CREAR_TABLA_CAMILLA);
        db.execSQL(SQL_CREAR_TABLA_REPORTE);
        db.execSQL(SQL_CREAR_TABLA_SEDE);
        db.execSQL(SQL_CREAR_TABLA_BLOQUE);
        db.execSQL(SQL_CREAR_TABLA_PISO);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }



}
