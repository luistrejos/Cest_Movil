package com.cest.cest_mobile;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InfoElemento extends AppCompatActivity {

    private String id;
    private String tipo;
    private String letra_bloque;
    private String nombre_bloque;
    private String piso;
    private String sede;
    private TextView txtId;
    private TextView txtDescripcion;
    private ImageView imgElemento;
    private Button btnUbicado;
    private Button btnUso;
    private Button btnDano;

    Dialog dialogo;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        dialogo = new Dialog(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_elemento);

        this.btnUbicado = (Button) findViewById(R.id.btnUbicado);
        this.btnDano = (Button) findViewById(R.id.btnDano);
        this.btnUso = (Button) findViewById(R.id.btnUso);

        this.id = getIntent().getStringExtra("id");
        this.tipo = getIntent().getStringExtra("tipo");
        this.letra_bloque = getIntent().getStringExtra("letra_bloque");
        this.nombre_bloque = getIntent().getStringExtra("nombre_bloque");
        this.piso = getIntent().getStringExtra("piso");
        this.sede = getIntent().getStringExtra("sede");



        this.txtId = (TextView) findViewById(R.id.txtIdd);
        this.txtId.setText(this.id);

        this.txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        if (tipo.equalsIgnoreCase("extintor")){

            this.txtDescripcion.setText("Es un "+this.tipo
                    +" y se encuentra ubicado en la Sede "+this.sede
                    +" Bloque " + this.nombre_bloque + " (" + this.letra_bloque + ")"
                    + " en el Piso #" + this.piso);
        }
        else if (tipo.equalsIgnoreCase("camilla")){
            this.txtDescripcion.setText("Es una "+this.tipo
                    +" y se encuentra ubicada en la Sede " + this.sede
                    + " Bloque " + this.nombre_bloque + " (" + this.letra_bloque + ")"
                    + " en el Piso # " + this.piso);
        }

        this.imgElemento = (ImageView) findViewById(R.id.imgElemento);
        if(this.tipo.equalsIgnoreCase("extintor")){
            this.imgElemento.setImageResource(R.drawable.extintor);
        }else{
            this.imgElemento.setImageResource(R.drawable.camilla);
        }


        /**
         * Evento para el botón de reportar si el elemento consultado se encuentra en su sitio
         */
        this.btnUbicado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogo.setContentView(R.layout.reportar_sitio);
                dialogo.dismiss();
                dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogo.show();

                Button btnSi=(Button) dialogo.findViewById(R.id.btnYes);
                Button btnNo = (Button) dialogo.findViewById(R.id.btnNot);
                btnSi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(),"Si sirve", Toast.LENGTH_LONG).show();
                    }
                });
                btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(),"No sirve", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        this.btnDano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("APP","Generar Reporte");
                Intent i = new Intent(InfoElemento.this,GenerarReporte.class);
                startActivity(i);
            }
        });

    }

}
