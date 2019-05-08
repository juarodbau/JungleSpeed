import java.net.Socket;  
 public class DataHandler {  
      public static void syncDb(Socket s) {  
           Sender sender = new Sender(s);  
           sender.sendMessage("***start***");  
           sender.sendMessage("This is a message from the server");  
           sender.sendMessage("***stop***");  
      }  
 }  
