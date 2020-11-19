package com.exercisses20;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    private Connection connection;
    private int clientcount=0;
    private static final long serialVersionUID = 2L;

    public void start() throws IOException, ClassNotFoundException {
        PropReader inst = PropReader.getInstance();
        try(ServerSocket serverSocket = new ServerSocket(inst.intreadfropmProp("config.properties","server.port"))) { // waiting for clients
            System.out.println("Server Strated");
            while (true){
                Socket socket = serverSocket.accept(); // making actual connection
                if(socket != null) clientcount++; // TODO Check for normal run
                connection = new Connection(socket);
                System.out.println(connection.readMessage());
                connection.sendMessage(SimpleMessage.getMessage("server","recieved")); // TODO replace with method generating smth from previous message
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

