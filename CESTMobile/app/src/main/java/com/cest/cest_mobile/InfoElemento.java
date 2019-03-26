package com.cest.cest_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.textclassifier.TextClassification;
import android.widget.TextView;

public class InfoElemento extends AppCompatActivity {

    private String id;
    private String tipo;
    private String letra_bloque;
    private TextView txtId;
    private TextView txtDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_elemento);
        this.txtId = (TextView) findViewById(R.id.txtIdd);
        this.txtId.setText(getIntent().getStringExtra("id"));

        this.txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        this.txtDescripcion.setText("Este "+getIntent().getStringExtra("tipo")
                +" se encuentra ubicado en el bloque "+getIntent().getStringExtra("letra_bloque"));
    }
}
