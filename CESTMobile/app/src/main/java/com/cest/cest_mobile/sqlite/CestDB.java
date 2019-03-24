package com.cest.cest_mobile.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CestDB extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DATOS = "cestmovil.db";

    private static final int VERSION_ACTUAL = 1;

    private final Context contexto;

    interface Tablas {
        String ELEMENTO = "elemento";
        String EXTINTOR = "extintor";
        String CAMILLA = "camilla";
        String REPORTE = "reporte";
        String BLOQUE = "bloque";
        String SEDE = "sede";
        String PISO = "piso";
    }

    public CestDB(Context contexto) {
        super(contexto, NOMBRE_BASE_DATOS, null, VERSION_ACTUAL);
        this.contexto = contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
