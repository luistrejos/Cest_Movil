package com.cest.cest_mobile;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cest.cest_mobile.Controllers.ElementoController;
import com.cest.cest_mobile.Controllers.QRController;
import com.cest.cest_mobile.Database.CestMovilDB;
import com.google.zxing.integration.android.IntentIntegrator;

import java.util.Arrays;

public class ConsultarElemento extends AppCompatActivity {

    private Button btnConsultar;
    private Button btnQR;
    private EditText txtId;
    private ElementoController elmtCtrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_elemento);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        btnQR = (Button) findViewById(R.id.btnQR);
        txtId = (EditText) findViewById(R.id.txtId);
        CestMovilDB db = new CestMovilDB(this.getApplicationContext());
        db.getWritableDatabase().execSQL("drop table if exists elemento");
        db.getWritableDatabase().execSQL("create table if not exists elemento(id integer primary key, tipo text not null, letra_bloque text not null, nombre_bloque text not null, piso text not null, sede text not null)");

        elmtCtrl = new ElementoController(db);

        elmtCtrl.Crear("1","Camilla","A", "Administrativo", "1", "Central");
        elmtCtrl.Crear("2","Camilla","B","Orlando Cierra","3","Central");
        elmtCtrl.Crear("3","Extintor","I","Palogrande","2","Palogrande");
        elmtCtrl.Crear("4","Extintor","G","Ciencias Agropecuarias","3","Sancancio");

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtId.getText().toString().isEmpty()){
                    String id = txtId.getText().toString();
                    Log.i("APP: ",id);
                    if(id.length() < 6){
                        //Llamar a elemento controller
                        BuscarElemento(id);
                    }else{
                        Toast.makeText(v.getContext(), "El ID tiene más de 5 dígitos", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(v.getContext(), "El campo ID no puede estar vacío", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator scaner = new IntentIntegrator(ConsultarElemento.this);
                //scaner.setBeepEnabled(false);
                scaner.initiateScan();
                Log.i("APP","Escaneo iniciado");
            }
        });
    }

    /**
     * Método que activa la cámara para escanear el código QR
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.i("APP","Resultado escaneo");
        Log.i("APP","resultCode: "+resultCode);
        Log.i("APP","MainActivity: "+MainActivity.RESULT_OK);
        if ( resultCode == MainActivity.RESULT_OK){
            Log.i("APP","OK");
            String id = new QRController().LeerQR(ConsultarElemento.this,requestCode,resultCode,data);
            BuscarElemento(id);
        }
    }

    /**
     * Método que invoca la vista con la información del elememento a consultar
     * @param id Identificador del elemento a consultar
     */
    private void BuscarElemento(String id){
        String[] infoElemento = elmtCtrl.BuscarId(id);
        if(infoElemento != null){
            Log.d("APP: ", Arrays.toString(infoElemento));
            Intent i = new Intent(ConsultarElemento.this, InfoElemento.class);
            i.putExtra("id",infoElemento[0]);
            i.putExtra("tipo",infoElemento[1]);
            i.putExtra("letra_bloque",infoElemento[2]);
            i.putExtra("nombre_bloque",infoElemento[3]);
            i.putExtra("piso",infoElemento[4]);
            i.putExtra("sede",infoElemento[5]);
            startActivity(i);
        }else{
            Toast.makeText(getApplicationContext(), "El ID no se encuentra registrado", Toast.LENGTH_LONG).show();
        }
        finish();
    }
}
