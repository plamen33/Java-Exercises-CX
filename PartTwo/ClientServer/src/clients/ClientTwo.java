package clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTwo {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 7000)){
            System.out.println("Client started");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            String inputData = "";
            String responseFromServer = "";

            do{
                System.out.println(ANSI_RESET + "Enter command to be send to server: ");

                inputData = scanner.nextLine();

                output.println(inputData);
                if(!inputData.equals("end.")){
                    responseFromServer = input.readLine();
                    System.out.println(ANSI_PURPLE + responseFromServer);
                    if(responseFromServer==null){
                        break;
                    }
                }
            }
            while(!inputData.equals("end."));
        }
        catch(IOException e){
            System.out.println("Exception in client: " + e.getMessage());
        }
    }
}
