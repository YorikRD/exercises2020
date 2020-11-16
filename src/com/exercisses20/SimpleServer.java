package com.exercisses20;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    private Connection connection;
    private int clientcount=0;
    private static final long serialVersionUID = 1L;

    public void start() throws IOException, ClassNotFoundException {
        try(ServerSocket serverSocket = new ServerSocket(PropReader.intreadfropmProp("config.properties","server.port"))) { // waiting for clients
            System.out.println("Server Strated");
            while (true){
                Socket socket = serverSocket.accept(); // making actual connection
                clientcount++;
                connection = new Connection(socket);
                System.out.println(connection.readMessage());
                connection.sendMessage(SimpleMessage.getMessage("server","recieved"));
            }
        }
    }

    public int getClientcount() {
        return clientcount;
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

    private String cmdAnswer (SimpleMessage message){
        String answer = null;
        answer = message.getText();

        return answer;
    }


}

