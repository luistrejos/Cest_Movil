package com.cest.cest_mobile;

import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class correoReportarDano extends AppCompatActivity {

    Button btnOk;
    EditText txtCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correo_dano);
        btnOk = (Button) findViewById(R.id.btnOk);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);


        this.btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Información enviada exitosamente", Toast.LENGTH_LONG).show();
                correoReportarDano.super.onBackPressed();
            }
        });
    }
}
