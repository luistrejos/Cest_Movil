package com.cest.cest_mobile;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cest.cest_mobile.Controllers.QRController;
import com.google.zxing.integration.android.IntentIntegrator;

public class MainActivity extends AppCompatActivity {

    private Button btnId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnId = (Button) findViewById(R.id.btnId);
        btnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("APP","Consulta ID");
                Intent i = new Intent(MainActivity.this, ConsultarElemento.class);
                startActivity(i);
            }
        });
    }

}
