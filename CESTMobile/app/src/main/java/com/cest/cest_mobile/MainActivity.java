package com.cest.cest_mobile;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cest.cest_mobile.Controllers.QRController;
import com.google.zxing.integration.android.IntentIntegrator;

public class MainActivity extends AppCompatActivity {

    private Button btnId;
    private Button btnEscanear;
    private String resultScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnId = (Button) findViewById(R.id.btnId);
        btnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ConsultarElemento.class);
                startActivity(i);
            }
        });

        btnEscanear = (Button) findViewById(R.id.btnEscanear);
        btnEscanear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //escanear(v);
                IntentIntegrator scaner = new IntentIntegrator(MainActivity.this);
                //scaner.setBeepEnabled(false);
                scaner.initiateScan();
            }
        });

    }

    public void escanear(View view) {
        IntentIntegrator scaner = new IntentIntegrator(this);
        //scaner.setBeepEnabled(false);
        scaner.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if ( resultCode == MainActivity.RESULT_OK){
            new QRController().LeerQR(this.getApplicationContext(),requestCode,resultCode,data);
        }
    }

}
