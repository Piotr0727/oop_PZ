package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.function.Consumer;

public class ServerThread extends Thread {
    private Socket socket;
    private PrintWriter writer; // Wysyla linijke do serwera
    private BufferedReader reader; // Odczytuje cos od kogos

    private String host;
    private int port;
    private Consumer<String> onMessageReceived;

    public ServerThread(String host, int port, Consumer<String> onMessageReceived){
        this.host = host;
        this.port = port;
        this.onMessageReceived = onMessageReceived;
    }

    public void send(double x, double y, double radius, String color){
        String message = "Srodek: (" + x + ";" + y + ")\nPromien: " + radius + "\nKolor: " + color;
        writer.println(message);
    }

    @Override
    public void run(){
        try {
            socket = new Socket(host,port);
            writer = new PrintWriter(socket.getOutputStream(),true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message;
            while((message = reader.readLine()) != null){
                System.out.println("Otrzymano z serwera: " + message);
                onMessageReceived.accept(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
