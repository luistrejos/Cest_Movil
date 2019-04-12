package com.cest.cest_mobile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;


public class GenerarReporte extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportar_dano);
        CheckBox ckbVencido = (CheckBox)findViewById(R.id.ckbVencido);
        CheckBox ckbDefectuoso = (CheckBox)findViewById(R.id.ckbDefectuoso);
        CheckBox ckbRoto= (CheckBox)findViewById(R.id.ckbRoto);
        CheckBox ckbCorreas = (CheckBox)findViewById(R.id.ckbSCorreas);
        CheckBox ckbAlmoadilla = (CheckBox)findViewById(R.id.ckbSAlmoadilla);

    }



}
