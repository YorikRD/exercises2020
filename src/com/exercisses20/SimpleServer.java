package com.exercisses20;

import com.exercisses20.auxiliary.LocalhostOrLan;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class SimpleServer {
    private Connection connection;
    private static final long serialVersionUID = 2L;
    private HashSet<String> clients = new HashSet<>();


    public void start(LocalhostOrLan choice) throws IOException, ClassNotFoundException {
        PropReader inst = PropReader.getInstance();
        try(ServerSocket serverSocket = new ServerSocket(inst.intreadfropmProp(choice.getPath(),choice.getPort()))) { // waiting for clients
            System.out.println("Server Strated variant: "+choice);
            while (true){
                Socket socket = serverSocket.accept(); // making actual connection
                connection = new Connection(socket);
                SimpleMessage newM = connection.readMessage();
                clients.add(newM.getSender());
                System.out.println(newM);
                connection.sendMessage(messageReturner(newM)); // TODO replace with method generating smth from previous message
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



    private SimpleMessage messageReturner (SimpleMessage message){
        String string = null;
        switch (message.getText())     {
            case "/count":
                string = "Current number of unique Logins is: "+clients.size();
                break;
            case "/ping":
                string = "Time of initial message departure: "+message.getDateTime();
                break;
            default:
                string = "recieved";
        }
        SimpleMessage answer = SimpleMessage.getMessage("server",string);

        return answer;
    }


}

