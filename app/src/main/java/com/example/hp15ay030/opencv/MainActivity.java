package com.example.hp15ay030.opencv;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.OpenCVLoader;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        1);
            }
        }



        Button cameraInit = (Button) findViewById(R.id.menuautos);
        Button cameraInitr = (Button) findViewById(R.id.cameraInitr);
        Button detecciontrasera = (Button) findViewById(R.id.deteccionTrasera);
        Button camerabordestrasera = (Button) findViewById(R.id.cameraBordestrasera);
        Button cameraInitbf = (Button) findViewById(R.id.cameraBordesfrontal);
        cameraInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(i);
            }
        });

        cameraInitr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),RfacialActivity.class);
                startActivity(i);
            }
        });

        detecciontrasera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TfacialActivity.class);
                startActivity(i);
            }
        });

        camerabordestrasera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),BordesActivity.class);
                startActivity(i);
            }
        });

        cameraInitbf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),BordefActivity.class);
                startActivity(i);
            }
        });
    }
}
