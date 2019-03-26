package com.cest.cest_mobile.Controllers;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.cest.cest_mobile.Database.CestMovilDB;
import com.cest.cest_mobile.Database.DatabaseSchema.Elemento;

public class ElementoController {

    private CestMovilDB db;

    public ElementoController(CestMovilDB db){
        this.db = db;
    }

    /*Método para crear un registro en la case de datos*/
    public void Create (String id, String tipo, String letra_bloque){
        SQLiteDatabase db = this.db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Elemento.ID, Integer.valueOf(id));
        values.put(Elemento.TIPO, tipo);
        values.put(Elemento.LETRA_BLOQUE, letra_bloque);
        db.insert(Elemento.TABLE_NAME, null,values);
        db.close();
    }
}
