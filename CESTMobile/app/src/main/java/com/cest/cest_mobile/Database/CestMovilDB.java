package com.cest.cest_mobile.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.cest.cest_mobile.Database.DatabaseSchema.*;

public class CestMovilDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "cest_movil.db";

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
            + Extintor.FICHA_TECNICA + " text not null, "
            + "foreign key ("+Extintor.FICHA_TECNICA+") references "+FichaTecnica.TABLE_NAME+"("+FichaTecnica.TIPO+"),"
            + "foreign key ("+Extintor.ID_ELEMENTO+") references "+Elemento.TABLE_NAME+"("+Elemento.ID+"))";

    private static final String SQL_CREAR_TABLA_CAMILLA = "create table if not exists "
            + Camilla.TABLE_NAME +"("
            + Camilla.ID +" integer primary key, "
            + Camilla.ID_ELEMENTO + " integer not null, "
            + Camilla.TIPO + " text not null, "

            + "foreign key ("+Camilla.ID_ELEMENTO+") references "+Elemento.TABLE_NAME+"("+Elemento.ID+"))";

    private static final String SQL_CREAR_TABLA_FICHATECNICA = "create table if not exists "
            + FichaTecnica.TABLE_NAME +"("
            + FichaTecnica.TIPO +" text primary key, "
            + FichaTecnica.DESCRIPCION + " text not null)";

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

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREAR_TABLA_PISO);
        db.execSQL(SQL_CREAR_TABLA_BLOQUE);
        db.execSQL(SQL_CREAR_TABLA_SEDE);
        db.execSQL(SQL_CREAR_TABLA_REPORTE);
        db.execSQL(SQL_CREAR_TABLA_CAMILLA);
        db.execSQL(SQL_CREAR_TABLA_EXTINTOR);
        db.execSQL(SQL_CREAR_TABLA_FICHATECNICA);
        db.execSQL(SQL_CREAR_TABLA_ELEMENTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists "+Piso.TABLE_NAME);
        db.execSQL("drop table if exists "+Bloque.TABLE_NAME);
        db.execSQL("drop table if exists "+Sede.TABLE_NAME);
        db.execSQL("drop table if exists "+Reporte.TABLE_NAME);
        db.execSQL("drop table if exists "+Camilla.TABLE_NAME);
        db.execSQL("drop table if exists "+FichaTecnica.TABLE_NAME);
        db.execSQL("drop table if exists "+Extintor.TABLE_NAME);
        db.execSQL("drop table if exists "+Elemento.TABLE_NAME);
        onCreate(db);
    }

}
