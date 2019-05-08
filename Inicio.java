package com.dam.appcliente2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {


    private Button dos;
    private Button cuatro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inicio);
        dos = (Button) findViewById(R.id.dosButton);
        cuatro = (Button) findViewById(R.id.cuatroButton);



        dos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Pruebas.class);
                startActivityForResult(intent, 0);
            }
        });

        cuatro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Pruebas.class);
                startActivityForResult(intent, 1);
            }
        });

        Log.d("LOG", "en inicio");

    }
}
