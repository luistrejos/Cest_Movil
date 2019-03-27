package com.cest.cest_mobile;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.textclassifier.TextClassification;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoElemento extends AppCompatActivity {

    private String id;
    private String tipo;
    private String letra_bloque;
    private TextView txtId;
    private TextView txtDescripcion;
    private ImageView imgElemento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_elemento);
        this.id = getIntent().getStringExtra("id");
        this.tipo = getIntent().getStringExtra("tipo");
        this.letra_bloque = getIntent().getStringExtra("letra_bloque");


        this.txtId = (TextView) findViewById(R.id.txtIdd);
        this.txtId.setText(this.id);

        this.txtDescripcion = (TextView) findViewById(R.id.txtDescripcion);
        this.txtDescripcion.setText("Este/a "+this.tipo
                +" se encuentra ubicado en el bloque "+this.letra_bloque);

        this.imgElemento = (ImageView) findViewById(R.id.imgElemento);
        if(this.tipo.equalsIgnoreCase("extintor")){
            this.imgElemento.setImageResource(R.drawable.extintor);
        }else{
            this.imgElemento.setImageResource(R.drawable.camilla);
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getParent());
        // Get the layout inflater
        LayoutInflater inflater = getParent().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.reportar_sitio, null))
                // Add action buttons
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        InfoElemento.this.getDialog().cancel();
                    }
                });
        return builder.create();

    }
}
