package com.dam.appcliente2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Pruebas extends Activity {
    private Socket client;
    private PrintWriter printwriter;
    private BufferedReader bufferedReader;
    private ProgressDialog pDialog;
    String host = "192.168.0.27";
    int port = 54325;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pruebas);
    }
    /**
     * This AsyncTask create the connection with the server and initialize the
     * chat senders and receivers.
     */
    private class ChatOperator extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                client = new Socket(host, port); // Creating the
                // server socket.
                if (client != null) {
                    printwriter = new PrintWriter(client.getOutputStream(),
                            true);
                    InputStreamReader inputStreamReader = new InputStreamReader(
                            client.getInputStream());
                    bufferedReader = new BufferedReader(inputStreamReader);
                } else {
                    System.out
                            .println("Server has not bean started on port 4444.");
                }
            } catch (UnknownHostException e) {
                System.out.println("Faild to connect server " + host);
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Faild to connect server " + host);
                e.printStackTrace();
            }
            return null;
        }
        /**
         * Following method is executed at the end of doInBackground method.
         */
        @Override
        protected void onPostExecute(Void result) {
            final Sender messageSender = new Sender(); // Initialize chat sender
            // AsyncTask.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                messageSender.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            } else {
                messageSender.execute();
            }
            Receiver receiver = new Receiver(); // Initialize chat receiver
            // AsyncTask.
            receiver.execute();
        }
    }
    /**
     * This AsyncTask continuously reads the input buffer and show the chat
     * message if a message is availble.
     */
    private class Receiver extends AsyncTask<Void, Void, Void> {
        private String message;
        @Override
        protected Void doInBackground(Void... params) {
            while (true) {
                try {
                    if (bufferedReader.ready()) {
                        message = bufferedReader.readLine();
                        publishProgress(null);
                    }
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                }
            }
        }
        @Override
        protected void onProgressUpdate(Void... values) {
            try {
                Toast.makeText(getApplicationContext(),
                        "Received message: "+message, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
    /**
     * This AsyncTask sends the chat message through the output stream.
     */
    private class Sender extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            printwriter.write("listo" + "\n");
            printwriter.flush();

            Log.d("message", "send");
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
        }
    }

    private class Sender2 extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            printwriter.write("tocado" + "\n");
            printwriter.flush();

            Log.d("message", "send");
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
        }
    }

    public void LoadAndSave(View v) {
        pDialog = new ProgressDialog(Pruebas.this);
        pDialog.setMessage("Loading meassage. Please wait...");
        //pDialog.setIndeterminate(false);
       // pDialog.setCancelable(false);
        pDialog.show();
        ChatOperator chatOperator = new ChatOperator();
        chatOperator.execute();
    }

    public void LoadAndSave2(View v) {
        pDialog = new ProgressDialog(Pruebas.this);
        pDialog.setMessage("Loading meassage. Please wait...");
       // pDialog.setIndeterminate(false);
        //pDialog.setCancelable(false);
        pDialog.show();
        ChatOperator chatOperator = new ChatOperator();
        chatOperator.execute();
    }
}// activity ends
