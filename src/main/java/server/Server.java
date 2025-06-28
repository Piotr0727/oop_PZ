package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket; // To jest gniazdo serwera potrzebne przy polaczeniu
    private List<ClientThread> clients = new ArrayList<>(); // Lepiej miec liste klientow latwo sie takim czyms zarzadza

    public void start(int port){
        try {
            serverSocket = new ServerSocket(port); // Dopiero tutaj tworzymy
            System.out.println("Serwer nasluchuje na porcie: " + port);
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Nowy klient: " + socket.getInetAddress());
                ClientThread clientThread = new ClientThread(socket, this);
                clients.add(clientThread);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void broadcast(String message){
        for(ClientThread client : clients)
            client.sendMessage(message);
    }
}
