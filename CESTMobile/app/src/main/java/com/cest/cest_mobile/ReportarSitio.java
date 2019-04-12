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

public class ReportarSitio extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reportar_sitio);


    }

}
