package com.cest.cest_mobile.Controller;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.cest.cest_mobile.MainActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class LecturaCodigo extends Activity {

    IntentIntegrator scaner;
    String resultScan;


    public void LecturaCodigo(Activity intent){
        this.scaner = new IntentIntegrator(intent);
        this.scaner.setBeepEnabled(false);
        this.resultScan = "";
    }

    public String leerCodiog(){
        this.scaner.initiateScan();
        return this.resultScan;
    }


    /**
     * Metodo que realiza la lectura del codigo QR
     * @param requestCode
     * @param resultCode
     * @param data
     */
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
