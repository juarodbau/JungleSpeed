package com.dam.appcliente2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
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
        setContentView(R.layout.activity_main_sala);

        atras2 = (Button) findViewById(R.id.atrasButton2);
        totem = (ImageView) findViewById(R.id.imageView17);

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
        MyATaskCliente myATaskYW = new MyATaskCliente();
        myATaskYW.execute("hola");

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

            try {
                Log.i("PRU", values[0]);
                //Se conecta al servidor
                InetAddress serverAddr = InetAddress.getByName(ADDRESS);
                Socket socket = new Socket(serverAddr, SERVERPORT);
                if ( i < 1) {
                    sss[0] = socket; // Creamos un array de sockets para guardar el socket una vez el jugador entre en la sala
                }else {
                    sss[1] = socket;
                }
                    i++;
                //envia peticion de cliente
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
            } catch (UnknownHostException ex) {
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
