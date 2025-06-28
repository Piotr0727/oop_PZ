package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket; // To jest tak jakby wtyczka za pomoca ktorej uzytkownik sie potem podlacza
    private Server server;
    private PrintWriter writer;

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            String message;
            while((message = reader.readLine()) != null ){
                System.out.println("Odebrane od klienta: " + message);
                server.broadcast(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String message) {
        if(writer != null)
            writer.println(message);
    }

}

