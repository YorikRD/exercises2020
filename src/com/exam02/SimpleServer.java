package com.exam02;

import com.exam02.auxiliary.LocalhostOrLan;
import com.exercisses20.SimpleMessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.concurrent.*;

public class SimpleServer {
    private Connection connection;
    private static final long serialVersionUID = 2L;
    private HashSet<String> clients = new HashSet<>();

    private ExecutorService comandService = Executors.newFixedThreadPool(3);

    /**
     * @param choice Choice between enum values generate keys for config.properties
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void start(LocalhostOrLan choice) throws IOException, ClassNotFoundException {
        PropReader inst = PropReader.getInstance();
        try (ServerSocket serverSocket = new ServerSocket(inst.intreadfropmProp(choice.getPath(), choice.getPort()))) { // waiting for clients
            System.out.println("Server Started variant: " + choice + " with port: " + serverSocket.getLocalPort());
            Socket socket = serverSocket.accept(); // making actual connection
            connection = new Connection(socket);
            System.out.println("connection establiched");
            while (true) {
                SimpleMessage2 newM = connection.readMessage();
                clients.add(newM.getSender());
                System.out.println(newM);
                SimpleMessage2 answer = messageReturner(newM);
                System.out.println("server: " + answer);
                switch (answer.getText()) {
                    case "leaveCode1":
                        connection.sendMessage(answer);
                        try {
                            connection.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return;
                }
                connection.sendMessage(answer);
            }
        }
    }


    public static void main(String[] args) {
        SimpleServer server = new SimpleServer();
        try {
            server.start(LocalhostOrLan.LOCALHOST);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param message link to analised message recieved from a client
     * @return returns a message to send client
     */
    private SimpleMessage2 messageReturner(SimpleMessage2 message) {
        String string = null;
        switch (message.getText()) {
            case "/count":
                string = "Current number of unique Logins is: " + clients.size();
                break;
            case "/ping":
                string = "Time of initial message departure: " + message.getDateTime();
                break;
            case " leaves the conference":
                string = "leaveCode1";
                break;
            case "/list":
                string = clients.toString();
                break;
            case "/close":
                string = " closecode";
                break;
            default:
                string = "received";
        }
        SimpleMessage2 answer = SimpleMessage2.getMessage("server", string);

        return answer;
    }


}

