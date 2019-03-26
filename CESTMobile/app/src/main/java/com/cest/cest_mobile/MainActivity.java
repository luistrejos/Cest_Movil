package com.cest.cest_mobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cest.cest_mobile.Database.CestMovilDB;

public class MainActivity extends AppCompatActivity {

    private Button btnId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CestMovilDB db = new CestMovilDB(this.getApplicationContext());
        //db.Create("Luis Trejos");
        //Toast.makeText(this, "Hey", Toast.LENGTH_LONG).show();

        btnId = (Button) findViewById(R.id.btnId);
        btnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SabesElId.class);
                startActivity(i);
            }
        });

    }


}
