import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

public static Socket connection;

public static void main(String[] args) throws IOException {

    
	ServerSocket ss;
    System.out.print("Inicializando servidor... ");
    
    try {
    	
    	// Variables
    	
        System.out.println("\t[OK]");
        ss = new ServerSocket(54325);
        int idSesion = 0;
        boolean auxSesion = true;
        boolean auxMesa = true;
        Socket[] ssArraySesion = new Socket[2];
        
        // While que espera conexiones - La conexion
        
        while (auxSesion) { 
            Socket socket;
            socket = ss.accept();
            ssArraySesion[idSesion]=socket;
            System.out.println("Nueva conexión entrante: "+socket);
            idSesion++;
            if (idSesion == 2) {
            	auxSesion = false;
            	for ( int i = 0; i < idSesion; i++) {
            		System.out.println("Listado de conexiones: "+ssArraySesion[i]);
            	}
              }
        }
        
        // While de la mesa - La partida
        
        while (auxMesa) { 
            	
        	DataInputStream msg_rx = new DataInputStream(ssArraySesion[0].getInputStream());
        	if (msg_rx.available()==0) { // Si no hay mensajes por parte del cliente
        		
        		while(true) {}
        		
        	}else {
        		
            	System.out.println(msg_rx.readUTF());
        		
        	}
        
        }
            
        
    } catch (IOException ex) {
        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
    	}
	}
}
