import java.io.BufferedReader;  
 import java.io.IOException;  
 import java.io.InputStreamReader;  
 import java.io.PrintWriter;  
 import java.net.Socket;  
 class Reciever extends Thread{   
   String line=null;  
   BufferedReader is = null;  
   PrintWriter os=null;  
   Socket s=null;  
   public Reciever(Socket s){  
     this.s=s;  
   }  
   public void run() {  
   try{  
     is= new BufferedReader(new InputStreamReader(this.s.getInputStream()));  
     os=new PrintWriter(this.s.getOutputStream()); 

   }catch(IOException e){  
     System.out.println("IO error in server thread");  
   }  
   try {  
     line=is.readLine();  

     while(line.compareTo("QUIT")!=0){  
       os.println(line);  
       os.flush();  
       if(line.equals("syncDb")){  
            DataHandler a = new DataHandler();  
            a.syncDb(s);  
            break;  
       }  
       else{  
       //  
       System.out.println("Response to Client : "+line);  
       line=is.readLine();  
       }  
     }    
   } catch (IOException e) {  
     line=this.getName(); //reused String line for getting thread name  
     System.out.println("IO Error/ Client "+line+" terminated abruptly");  
   }  
   catch(NullPointerException e){  
     line=this.getName(); //reused String line for getting thread name  
     System.out.println("Client "+line+" Closed");  
   }  
   finally{    
   try{  
     System.out.println("Connection Closing..");  
     if (is!=null){  
       is.close();   
       System.out.println(" Socket Input Stream Closed");  
     }  
     if(os!=null){  
       os.close();  
       System.out.println("Socket Out Closed");  
     }  
     if (s!=null){  
     s.close();  
     System.out.println("Socket Closed");  
     }  
     }  
   catch(IOException ie){  
     System.out.println("Socket Close Error");  
   }  
   }//end finally  
   }  
 }  
