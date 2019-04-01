package com.dam.appcliente2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView response;

    private Button buttonConnect;
    private Button buttonHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonConnect = (Button) findViewById(R.id.connectButton);
        buttonHelp = (Button) findViewById(R.id.helpButton);

        //response = (TextView) findViewById(R.id.responseTextView);

        buttonConnect.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent (v.getContext(), MainActivitySala.class);

                startActivityForResult(intent, 0);
            }
        });

        buttonHelp.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivityHelp.class);

                startActivityForResult(intent, 1);
            }
        });


    }
}