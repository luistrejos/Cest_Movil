package com.cest.cest_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cest.cest_mobile.Database.CestMovilDB;

public class SabesElId extends AppCompatActivity {

    private Button btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sabes_el_id);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        CestMovilDB db = new CestMovilDB(this.getApplicationContext());
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
