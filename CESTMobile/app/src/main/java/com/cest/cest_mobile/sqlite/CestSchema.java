package com.cest.cest_mobile.sqlite;

public class CestSchema {

    interface ColumnasElemento {
        String ID = "id";
        String TIPO = "tipo";
        String LETRA_BLOQUE = "letra_bloque";
    }

    interface ColumnasExtintor {
        String ID = "id";
        String ID_ELEMENTO = "id_elemento";
        String CADUCIDADANIOS = "caducidadanios";
        String ESTADO = "estado";
        String FECHAULTIMARECARGA = "fechaultimarecarga";
        String FECHAVENCIMIENTO = "fechavencimiento";
        String TAMANIO = "tamanio";
        String CADUCIDAD_ANIOS = "caducidad_anios";
    }

    interface ColumnasCamilla  {String TABLE_NAME = "camilla";
        String ID = "id";
        String ID_ELEMENTO = "id_elemento";
        String TIPO = "tipo";
    }

    interface ColumnaReporte {
        String TABLE_NAME = "reporte";
        String ID = "id";
        String ID_ELEMENTO = "id_elemento";
        String ENVIADO = "enviado";
        String DESCRIPCION = "descripcion";
        String ARGUMENTOS = "argumentos";
        String ESTADO = "estado";
        String FECHAREPORTE = "fechareporte";
        String LEIDO = "leido";
        String NOTIFICADO = "notificado";
    }

    interface ColumnasBloque {
        String TABLE_NAME = "bloque";
        String LETRA = "letra";
        String NOMBRE = "nombre";
        String TIPO = "tipo";
    }

    interface ColumnasSede {
        String LETRA = "letra";
        String ID_SEDE = "id_sede";
        String NOMBRE = "nombre";
    }

    interface Piso {
        String NUMERO = "numero";
        String LETRA_BLOQUE = "letra_bloque";
    }

}
