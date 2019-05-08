package com.dam.appcliente2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivityHelp extends AppCompatActivity {


    private Button atras;
    private Button creditos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_help);
        atras = (Button) findViewById(R.id.atrasButton);
        creditos = (Button) findViewById(R.id.creditosButton);



        atras.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        creditos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Creditos.class);
                startActivityForResult(intent, 1);
            }
        });

        Log.d("LOG", "en help");

    }


}
