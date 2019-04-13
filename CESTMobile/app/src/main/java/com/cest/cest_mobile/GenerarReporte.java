package com.cest.cest_mobile;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.LinkedList;


public class GenerarReporte extends AppCompatActivity {
    private CheckBox ckbVencido ;
    private CheckBox ckbDefectuoso ;
    private CheckBox ckbRoto;
    private CheckBox ckbCorreas;
    private CheckBox ckbAlmoadilla;
    private Button btnEnviarReporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                AlertDialog.Builder alerta = new AlertDialog.Builder(GenerarReporte.this);
                alerta.setMessage("¿Deseas que nos contactemos contigo?")
                        .setCancelable(false)
                        .setPositiveButton(Html.fromHtml("<h1>Si</h1>"), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //pegar codigo de ventana correoReportarDano
                                Intent i = new Intent(GenerarReporte.this,correoDano.class);
                                startActivity(i);
                                //finish();
                            }
                        })
                        .setNegativeButton(Html.fromHtml("<font color='#0040FF'>No</font>"), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(),"Reporte generado exitosamente", Toast.LENGTH_LONG).show();
                                dialog.cancel();
                                finish();
                            }
                        });
                AlertDialog titulo = alerta.create();
                titulo.setTitle("Queremos saber mas de ti");
                titulo.show();
            }
        });
    }
    public LinkedList<String> seleccion(){
        LinkedList <String> listaSeleccion = new LinkedList<>();
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
