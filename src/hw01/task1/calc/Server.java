package hw01.task1.calc;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {

    private ServerSocket serverSocket  = null;
    private Socket socket = null;

    public Server(){

    }

    void runServer(){
        try {
            serverSocket = new ServerSocket(7777);
            socket = serverSocket.accept();
            System.out.println("Connected to server.");
            InputStream sin = socket.getInputStream();
            ObjectInputStream in = new ObjectInputStream(sin);
            Object obj = null;
            obj = in.readObject();
            Number n = (Number) obj;
            int res = n.calc();
            OutputStream oos = socket.getOutputStream();
            oos.write(res);
            socket.close();
        }catch (SocketException se){
            se.printStackTrace();
            System.exit(0);
        }catch (IOException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Server server = new Server();
        System.out.println("Server started");
        server.runServer();
    }
}
