package com.cest.cest_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class correoDano extends AppCompatActivity {
    Button btnSi;
    EditText txtCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correo_dano);
        btnSi=(Button) findViewById(R.id.btnSi);
        txtCorreo=(EditText) findViewById(R.id.txtCorreo);


        this.btnSi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Información enviada exitosamente", Toast.LENGTH_LONG).show();
                correoDano.super.onBackPressed();

            }
        });

    }
}
