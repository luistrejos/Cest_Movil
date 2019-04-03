package com.cest.cest_mobile;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cest.cest_mobile.Controllers.ElementoController;
import com.cest.cest_mobile.Database.CestMovilDB;

import java.util.Arrays;

public class ConsultarElemento extends AppCompatActivity {

    private Button btnConsultar;
    private EditText txtId;
    private ElementoController elmtCtrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_elemento);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        txtId = (EditText) findViewById(R.id.txtId);
        boolean bandera = getIntent().getBooleanExtra("bandera", false);
        CestMovilDB db = new CestMovilDB(this.getApplicationContext());
        //db.getWritableDatabase().execSQL("drop table if exists elemento");
        //db.getWritableDatabase().execSQL("create table if not exists elemento(id integer primary key, letra_bloque text not null, tipo text not null)");

        elmtCtrl = new ElementoController(db);


        if(bandera){
            Log.i("APP","QR ID: "+getIntent().getStringExtra("id"));
            BuscarElemento(getIntent().getStringExtra("id"));
        }

        //elmtCtrl.Crear("1","Camilla","A");
        //elmtCtrl.Crear("2","Camilla","B");
        //elmtCtrl.Crear("3","Extintor","C");
        //elmtCtrl.Crear("4","Extintor","D");

        /**
         * Evento del botón para buscar elemento por ID
         */
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
            startActivity(i);
        }else{
            Toast.makeText(getApplicationContext(), "El ID no se encuentra registrado", Toast.LENGTH_LONG).show();
        }
    }

}
