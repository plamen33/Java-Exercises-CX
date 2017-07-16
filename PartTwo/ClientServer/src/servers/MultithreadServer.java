package servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class MultithreadServer extends Thread {
    private Socket socket;
    private String stopServer = "";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    MultithreadServer(Socket inputSocket){
        this.socket = inputSocket;
    }

    @Override
    public void run(){
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while(true){
                String clientMessage = input.readLine();
                System.out.println("Client says: " + clientMessage);
                if(clientMessage.equals("end.")){
                    System.out.println(ANSI_BLUE + "A Client was stopped." + ANSI_RESET);
                    break;
                }
                if(clientMessage.equals("stop server")){
                    stopServer = "stop";
                    break;
                }
                output.println("Server echo: " + clientMessage);
            }
        }
        catch(IOException e){
            System.out.println("Exception in server: " + e.getMessage());
        }
        finally{
            try{
                socket.close();
                if(stopServer.equals("stop")){
                    System.out.println(ANSI_PURPLE + "Server stopped");
                    System.exit(0);
                }
            }
            catch(IOException e){
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(7000)){
            System.out.println(ANSI_GREEN + "MultithreadServer started" + ANSI_RESET);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println(ANSI_BLUE + "A new Client is connected" + ANSI_RESET);
                new MultithreadServer(socket).start();
            }
        }
        catch(IOException e){
            System.out.println("Server exception happened, exception data is: " + e.getMessage());
        }
    }
}
