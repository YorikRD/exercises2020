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

    /**
     *
     * @param choice Choice between enum values generate keys for config.properties
     * @throws IOException
     * @throws ClassNotFoundException
     */
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
                connection.sendMessage(messageReturner(newM));
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
     *
     * @param message link to analised message recieved from a client
     * @return returns a message to send client
     */
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
                string = "received";
        }
        SimpleMessage answer = SimpleMessage.getMessage("server",string);

        return answer;
    }


}

