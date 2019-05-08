import java.io.IOException;  
 import java.io.PrintWriter;  
 import java.net.Socket;  
 public class Sender {  
   private PrintWriter out;  
   public Sender(Socket clientSocket) {  
     try {  
       out = new PrintWriter(clientSocket.getOutputStream(), true);  
     } catch (IOException e) {  
       e.printStackTrace();  
     }  
   }  
   public void sendMessage(String message) {  
        out.println(message); // Print the message on output stream.  
     out.flush();  
     message="";  
        System.out.println("Server: " + message + "\n"); // Print the message on chat window.  
   }  
 }  
