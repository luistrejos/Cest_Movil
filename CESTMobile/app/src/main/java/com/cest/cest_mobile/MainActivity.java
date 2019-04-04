package com.cest.cest_mobile;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cest.cest_mobile.Controllers.QRController;
import com.google.zxing.integration.android.IntentIntegrator;

public class MainActivity extends AppCompatActivity {

    private Button btnId;
    private Button btnEscanear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnId = (Button) findViewById(R.id.btnId);
        btnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("APP","Consulta ID");
                Intent i = new Intent(MainActivity.this, ConsultarElemento.class);
                startActivity(i);
            }
        });

        btnEscanear = (Button) findViewById(R.id.btnEscanear);
        btnEscanear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator scaner = new IntentIntegrator(MainActivity.this);
                //scaner.setBeepEnabled(false);
                scaner.initiateScan();
                Log.i("APP","Escaneo iniciado");
            }
        });

    }

<<<<<<< HEAD
    public void escanear(View view) {

        IntentIntegrator scaner = new IntentIntegrator(this);

        scaner.initiateScan();
    }

=======
>>>>>>> 4f7c1f559b5957832424fec7784f8cc168ea0586
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.i("APP","Resultado escaneo");
        Log.i("APP","resultCode: "+resultCode);
        Log.i("APP","MainActivity: "+MainActivity.RESULT_OK);
        if ( resultCode == MainActivity.RESULT_OK){
            Log.i("APP","OK");
            new QRController().LeerQR(MainActivity.this,requestCode,resultCode,data);
        }
    }

}
