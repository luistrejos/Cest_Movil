package com.cest.cest_mobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cest.cest_mobile.Database.CestMovilDB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CestMovilDB db = new CestMovilDB(this.getApplicationContext());
        //db.Create("Luis Trejos");
        //Toast.makeText(this, db.Read(3), Toast.LENGTH_LONG).show();
    }


}
