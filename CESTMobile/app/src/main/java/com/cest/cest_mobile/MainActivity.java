package com.cest.cest_mobile;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cest.cest_mobile.Database.CestMovilDB;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    //variables
    /**
     * Está variable almacena el string
     * que se lea del código QR
     */
    String resultScan = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CestMovilDB db = new CestMovilDB(this.getApplicationContext());
        //db.Create("Luis Trejos");
        //Toast.makeText(this, db.Read(3), Toast.LENGTH_LONG).show();
    }

    public void escanear(View view) {

        IntentIntegrator scaner = new IntentIntegrator(this);

        scaner.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if ( resultCode == Activity.RESULT_OK){
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if(result != null) {
                if(result.getContents() == null) {
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                    this.resultScan = result.toString();
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }
    }
}
