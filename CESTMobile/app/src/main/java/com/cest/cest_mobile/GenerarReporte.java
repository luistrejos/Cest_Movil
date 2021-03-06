package com.cest.cest_mobile;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;


public class GenerarReporte extends AppCompatActivity {
    private CheckBox ckbVencido ;
    private CheckBox ckbDefectuoso ;
    private CheckBox ckbRoto;
    private CheckBox ckbCorreas;
    private CheckBox ckbAlmoadilla;
    private Button btnEnviarReporte;

    Dialog reporteDaño;

    LinkedList <String> listaSeleccion = new LinkedList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        reporteDaño = new Dialog(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportar_dano);
        ckbVencido = (CheckBox)findViewById(R.id.ckbVencido);
        ckbDefectuoso = (CheckBox)findViewById(R.id.ckbDefectuoso);
        ckbRoto= (CheckBox)findViewById(R.id.ckbRoto);
        ckbCorreas = (CheckBox)findViewById(R.id.ckbSCorreas);
        ckbAlmoadilla = (CheckBox)findViewById(R.id.ckbSAlmoadilla);
        btnEnviarReporte = (Button) findViewById(R.id.btnEnviarReporte);


        this.btnEnviarReporte.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                seleccion();
                if ( listaSeleccion.isEmpty() ){
                    Toast.makeText(v.getContext(),"No hay ningun daño seleccionado", Toast.LENGTH_LONG).show();
                }
                else {
                    reporteDaño.setContentView(R.layout.activity_correo_dano);
                    reporteDaño.dismiss();
                    reporteDaño.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    reporteDaño.show();
                    Button btn = (Button) reporteDaño.findViewById(R.id.btnOk);
                    final EditText correo = (EditText) reporteDaño.findViewById(R.id.txtCorreo);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String correoaux = correo.getText().toString();
                            if (!correoaux.isEmpty()) {
                                if (Patterns.EMAIL_ADDRESS.matcher(correoaux).matches()) {
                                    Toast.makeText(v.getContext(), "Se genero reporte exitosamente, nos pondremos en contacto con : " + correoaux, Toast.LENGTH_LONG).show();
                                    GenerarReporte.super.onBackPressed();
                                } else {
                                    Toast.makeText(v.getContext(), "Si deseas que nos contactemos debe ser un correo válido", Toast.LENGTH_LONG).show();
                                }
                            }
                            else{
                            Toast.makeText(v.getContext(), "Se genero reporte exitosamente", Toast.LENGTH_LONG).show();
                            GenerarReporte.super.onBackPressed();
                        }}
                    });
                }
            }});
    }

    public LinkedList<String> seleccion(){

        if (ckbVencido.isChecked()==true){
            listaSeleccion.add("Vencido");
        }
        if (ckbDefectuoso.isChecked()==true){
            listaSeleccion.add("Defectuoso");
        }
        if (ckbRoto.isChecked()==true){
            listaSeleccion.add("Roto");
        }
        if (ckbCorreas.isChecked()==true){
            listaSeleccion.add("Sin Correas");
        }
        if (ckbAlmoadilla.isChecked()==true){
            listaSeleccion.add("Sin Almoadillas");
        }
        Log.i("imprimir",listaSeleccion.toString());
        return listaSeleccion;
    }


}
