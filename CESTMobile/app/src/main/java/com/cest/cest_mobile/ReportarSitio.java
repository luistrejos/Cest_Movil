package com.cest.cest_mobile;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cest.cest_mobile.Controllers.QRController;
import com.google.zxing.integration.android.IntentIntegrator;

public class ReportarSitio extends AppCompatActivity {

    Button btnSi;
    Button btnNo;
    EditText txtCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reportar_sitio);
        btnSi=(Button) findViewById(R.id.btnYes);
        btnNo=(Button) findViewById(R.id.btnNot);
        txtCorreo=(EditText) findViewById(R.id.txtCorreo);

        Toast.makeText(this,"reportando sitio", Toast.LENGTH_LONG).show();
        this.btnSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Si se encuentra", Toast.LENGTH_LONG).show();
                ReportarSitio.super.onBackPressed();

            }
        });

        this.btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo=txtCorreo.getText().toString();

                if(correo.isEmpty()){
                    Toast.makeText(v.getContext(),"El Reporte ha sido Guardado", Toast.LENGTH_LONG).show();
                    ReportarSitio.super.onBackPressed();
                }else {
                    Toast.makeText(v.getContext(), "Reporte Guardado,  nos pondremos en contacto: " + correo, Toast.LENGTH_LONG).show();
                    ReportarSitio.super.onBackPressed();
                }
            }
        });


    }

}
