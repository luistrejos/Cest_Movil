package com.cest.cest_mobile.Database;

import android.provider.BaseColumns;

public class DatabaseSchema {

    public static abstract class Elemento implements BaseColumns{
        public static final String TABLE_NAME = "elemento";
        public static final String ID = "id";
        public static final String TIPO = "tipo";
        public static final String LETRA_BLOQUE = "letra_bloque";
        public static final String NOMBRE_BLOQUE = "nombre_bloque";
        public static final String PISO = "piso";
        public static final String SEDE = "sede";
    }

    public static abstract class Extintor implements BaseColumns{
        public static final String TABLE_NAME = "extintor";
        public static final String ID = "id";
        public static final String ID_ELEMENTO = "id_elemento";
        public static final String CADUCIDADANIOS = "caducidadanios";
        public static final String ESTADO = "estado";
        public static final String FECHAULTIMARECARGA = "fechaultimarecarga";
        public static final String FECHAVENCIMIENTO = "fechavencimiento";
        public static final String TAMANIO = "tamanio";
        public static final String FICHA_TECNICA = "ficha_tecnica";
    }

    public static abstract class Camilla implements BaseColumns{
        public static final String TABLE_NAME = "camilla";
        public static final String ID = "id";
        public static final String ID_ELEMENTO = "id_elemento";
        public static final String TIPO = "tipo";

    }

    public static abstract class FichaTecnica implements BaseColumns{
        public static final String TABLE_NAME = "fichatecnica";
        public static final String TIPO = "tipo";
        public static final String DESCRIPCION = "descripcion";
    }

    public static abstract class Reporte implements BaseColumns{
        public static final String TABLE_NAME = "reporte";
        public static final String ID = "id";
        public static final String ID_ELEMENTO = "id_elemento";
        public static final String ENVIADO = "enviado";
        public static final String DESCRIPCION = "descripcion";
        public static final String ARGUMENTOS = "argumentos";
        public static final String ESTADO = "estado";
        public static final String FECHAREPORTE = "fechareporte";
        public static final String LEIDO = "leido";
        public static final String NOTIFICADO = "notificado";
    }

    public static abstract class Bloque implements BaseColumns{
        public static final String TABLE_NAME = "bloque";
        public static final String LETRA = "letra";
        public static final String NOMBRE = "nombre";
        public static final String ID_SEDE = "id_Sede";
    }

    public static abstract class Sede implements BaseColumns{
        public static final String TABLE_NAME = "sede";
        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
    }

    public static abstract class Piso implements BaseColumns{
        public static final String TABLE_NAME = "piso";
        public static final String NUMERO = "numero";
        public static final String LETRA_BLOQUE = "letra_bloque";
    }

}
