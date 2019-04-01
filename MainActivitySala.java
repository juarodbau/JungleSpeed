package com.dam.appcliente2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivitySala extends AppCompatActivity {
    String response = "";
    Socket socket = null;
    ImageView mazo1;
    ImageView mazo2;
    ImageView mazo3;
    ImageView mazo4;

    private Button atras2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sala);
        Log.d("LOG", "en sala so");

        Cliente myClient = new Cliente("192.168.0.27",54322);
        myClient.execute();
        //mazo1 = (ImageView) findViewById(R.id.mazo1);
        //mazo2 = (ImageView) findViewById(R.id.mazo2);
        //mazo3 = (ImageView) findViewById(R.id.mazo3);
        //mazo4 = (ImageView) findViewById(R.id.mazo4);

        atras2 = (Button) findViewById(R.id.atrasButton2);
        atras2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    socket.close();
                }catch (IOException e){

                    }
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent, 2);
            }
        });

        Log.d("LOG", "en sala");
    }

}
