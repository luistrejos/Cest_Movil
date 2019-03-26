package com.cest.cest_mobile.Controllers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cest.cest_mobile.Database.CestMovilDB;
import com.cest.cest_mobile.Database.DatabaseSchema.Elemento;

public class ElementoController {

    private CestMovilDB db;

    public ElementoController(CestMovilDB db){
        this.db = db;
    }

    /*Método para crear un registro en la case de datos*/
    public void Crear (String id, String tipo, String letra_bloque){
        SQLiteDatabase db = this.db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Elemento.ID, Integer.valueOf(id));
        values.put(Elemento.TIPO, tipo);
        values.put(Elemento.LETRA_BLOQUE, letra_bloque);
        db.insert(Elemento.TABLE_NAME, null,values);
        db.close();
    }

    /*Método para leer un registro de la base de datos*/
    public String[] buscarId (String id){
        SQLiteDatabase db = this.db.getReadableDatabase();
        String[] projection = {Elemento.ID, Elemento.TIPO, Elemento.LETRA_BLOQUE};

        Cursor cursor =
            db.query(Elemento.TABLE_NAME,
                projection," id = ?",
                new String[] {id},
               null,
               null,
               null,
               null);
        if (cursor != null)
            cursor.moveToFirst();

        int n = cursor.getColumnCount();
        String[] infoElemento = new String[n];
        String[] columnas = cursor.getColumnNames();
        for (int i = 0; i < n; i++) {
            infoElemento[i] = cursor.getString(i);
        }
        db.close();
        return infoElemento;
    }

}
