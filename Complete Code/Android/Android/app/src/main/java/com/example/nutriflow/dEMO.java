package com.example.nutriflow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class dEMO extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        findViewById(R.id.sample).setOnClickListener(new View.OnClickListener() {
                                                         @Override
                                                         public void onClick(View v) {


                                                             Toast.makeText(getApplicationContext(), "Sample ", Toast.LENGTH_SHORT).show();
                                                         }
                                                     }
        );

    }
}