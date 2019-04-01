package com.dam.appcliente2;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteHelp extends Activity {

    String dstAddress;
    int dstPort;
    String response = "";
    TextView textResponse;


    ClienteHelp(String addr, int port, TextView textResponse) {

    }
}