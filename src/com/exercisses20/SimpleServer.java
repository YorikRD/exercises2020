package com.exercisses20;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    private Connection connection;
    private static final long serialVersionUID = 1L;

    public void start() throws IOException, ClassNotFoundException {
        try(ServerSocket serverSocket = new ServerSocket(8090)) { // waiting for clients
            System.out.println("Server Strated");
            while (true){
                Socket socket = serverSocket.accept(); // making actual connection
                connection = new Connection(socket);
                System.out.println(connection.readMessage());
                connection.sendMessage(SimpleMessage.getMessage("server","recieved"));
            }
        }
    }

    public static void main(String[] args) {
        SimpleServer server = new SimpleServer();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
} // ip 127.0.0.1 : 8090

