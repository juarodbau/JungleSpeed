package com.dam.appcliente2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivitySala2 extends AppCompatActivity {
    String response = "";
    Socket socket = null;

    private Button atras2;
    private ImageView totem;
    private Socket[] sss = new Socket[5];
    private int i = 0;
    /**
     * Puerto
     * */
    private static final int SERVERPORT = 54325;
    /**
     * HOST
     * */
    private static final String ADDRESS = "192.168.0.27";

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sala2);

        atras2 = (Button) findViewById(R.id.atrasButton2);
        totem = (ImageView) findViewById(R.id.imageView17);

            //envia peticion de cliente
        // hacer click en el boton de salir

        atras2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    MyATaskCliente myATaskYW = new MyATaskCliente();
                    myATaskYW.execute("salir");


                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent, 2);
            }
        });

    // Hacer click en el totem
        totem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MyATaskCliente myATaskYW = new MyATaskCliente();
                myATaskYW.execute("tocado");

            }
        });

        Log.d("LOG", "en sala");
    }

    @Override
    public void onResume(){
        super.onResume();
       // MyATaskCliente myATaskYW = new MyATaskCliente();
       // myATaskYW.execute("hola");

    }
    /**
     * Clase para interactuar con el servidor
     * */
    class MyATaskCliente extends AsyncTask<String,Void,String> {

        /**
         * Ventana que bloqueara la pantalla del movil hasta recibir respuesta del servidor
         */
        ProgressDialog progressDialog;

        /**
         * Se conecta al servidor y trata resultado
         */
        @Override
        protected String doInBackground(String... values) {

          try{
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String msg = values[0];
                out.writeUTF(msg);
                out.flush();
                //cierra conexion

              //  Log.i("LOGASO", request);

                if (msg.equals("salir")) {
                    DataOutputStream out2 = new DataOutputStream(sss[0].getOutputStream());
                    out2.writeUTF(msg);
                    out2.flush();
                    socket.close();
                }
                if (msg.equals("tocado")) {
                    DataOutputStream out2 = new DataOutputStream(sss[0].getOutputStream());
                    out2.writeUTF(msg);
                    out2.flush();

                }
        }  catch (UnknownHostException ex) {
            Log.e("E/TCP Client", "" + ex.getMessage());
        } catch (IOException ex) {
            Log.e("E/TCP Client", "" + ex.getMessage());
        }
            return "hola";
        }

        /**
         * Oculta ventana emergente y muestra resultado en pantalla
         */

    }
}
