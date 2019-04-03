package com.cest.cest_mobile.Controllers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.cest.cest_mobile.ConsultarElemento;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRController {

    public void LeerQR(Context context, int requestCode, int resultCode, @Nullable Intent data){
        Log.i("APP","Leyendo QR");
        String resultScan;
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                resultScan = result.getContents();
                Toast.makeText(context, "Código escaneado: " + resultScan, Toast.LENGTH_LONG).show();
                Intent i = new Intent(context, ConsultarElemento.class);
                i.putExtra("id",resultScan);
                i.putExtra("bandera", true);
                context.startActivity(i);
            }
        }
    }

}
