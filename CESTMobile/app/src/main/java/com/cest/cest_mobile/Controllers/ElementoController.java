package com.cest.cest_mobile.Controllers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cest.cest_mobile.Database.CestMovilDB;
import com.cest.cest_mobile.Database.DatabaseSchema.Elemento;

public class ElementoController {

    private CestMovilDB db;

    public ElementoController(CestMovilDB db){
        this.db = db;
    }

    /**
     * Método para insertar un elemento en la base de datos
     * @param id Identificador del elemento
     * @param tipo Tipo de elemento
     * @param letra_bloque Letra del bloque donde está ubicado el elemento
     */
    public void Crear (String id, String tipo, String letra_bloque, String nombre_bloque, String piso, String sede){
        SQLiteDatabase db = this.db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Elemento.ID, Integer.valueOf(id));
        values.put(Elemento.TIPO, tipo);
        values.put(Elemento.LETRA_BLOQUE, letra_bloque);
        values.put(Elemento.NOMBRE_BLOQUE, nombre_bloque);
        values.put(Elemento.PISO, piso);
        values.put(Elemento.SEDE, sede);
        try{
            db.insert(Elemento.TABLE_NAME, null,values);
        }catch (Exception e){

        }
        db.close();
    }

    /**
     * Método para buscar un elemento en la base de datos
     * @param id Identificador del elemento a buscar
     * @return Arreglo de Strings con la información del elemento
     */
    public String[] BuscarId (String id){
        SQLiteDatabase db = this.db.getReadableDatabase();
        String[] projection = {Elemento.ID, Elemento.TIPO, Elemento.LETRA_BLOQUE, Elemento.NOMBRE_BLOQUE, Elemento.PISO, Elemento.SEDE};

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
        for (int i = 0; i < n; i++) {
            try{
                infoElemento[i] = cursor.getString(i);
            }catch (Exception e){
                return null;
            }
        }
        db.close();
        return infoElemento;
    }

}
