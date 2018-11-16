package com.example.hp15ay030.opencv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button cars = (Button) findViewById(R.id.cars);
        Button car = (Button) findViewById(R.id.car);
        Button cascade = (Button) findViewById(R.id.cascade);


        cars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Intent i = new Intent(getApplicationContext(),OpenCVCamera.class);
        startActivity(i);
            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),CarActivity.class);
                startActivity(i);
            }
        });

        cascade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),CascadeActivity.class);
                startActivity(i);
            }
        });

    }
}
