package hw01.task1.calc;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket = null;
    private boolean isConnected = false;

    public Client(){

    }

    public void runClient(){
        while (!isConnected){
            try {
                socket = new Socket("localhost", 7777);
                System.out.println("Connected to server.");
                isConnected = true;
                OutputStream os = socket.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os);
                Number n = new Number(2,3);
                oos.writeObject(n);
                System.out.println("Sending...");
                System.out.println(socket.getInputStream().read());
                oos.flush();
                socket.close();

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        Client client = new Client();
        client.runClient();
    }

}
