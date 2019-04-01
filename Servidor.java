import java.io.IOException;
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
        ss = new ServerSocket(54322);
        System.out.println("\t[OK]");
        int idSession = 0;
        while (true) {
            Socket socket;
            socket = ss.accept();
            System.out.println("Nueva conexión entrante: "+socket);
            //((ServidorHilo) new ServidorHilo(socket, idSession)).start();
            idSession++;
            
        }
    } catch (IOException ex) {
        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
    	}
	}
}