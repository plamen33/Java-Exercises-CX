package clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class ClientOne {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
     try(Socket socket = new Socket("localhost", 7000)){
         System.out.println("Client started");
         BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
         Scanner scanner = new Scanner(System.in);
         String inputCommand;
         String responseFromServer;

         do{
             System.out.println("Enter command to be send to server: ");
             inputCommand = scanner.nextLine();

             output.println(inputCommand);
             if(!inputCommand.equals("end.")){
                 responseFromServer = input.readLine();
                 System.out.println(ANSI_BLUE + responseFromServer + ANSI_RESET);
             }
             if(inputCommand.equals("end.")){
                 scanner.close();
             }
         }
         while(!inputCommand.equals("end."));
     }
        catch(IOException e){
            System.out.println("Exception in client: " + e.getMessage());
        }
    }
}
