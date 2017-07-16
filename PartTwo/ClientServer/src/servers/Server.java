package servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(7000)){
            System.out.println("Server started");
            Socket socket = serverSocket.accept();
            System.out.println("Client is connected");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while(true){
                String clientMessage = input.readLine();
                System.out.println("Client says: " + clientMessage);
                if(clientMessage.equals("end.")){
                    System.out.println("Server stopped");
                    break;
                }
                output.println("Server echo: " + clientMessage);
            }
        }
        catch(IOException e){
            System.out.println("Server exception happened, exception data is: " + e.getMessage());
        }
    }
}
