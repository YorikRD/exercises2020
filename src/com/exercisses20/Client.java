package com.exercisses20;

import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;
    private static final long serialVersionUID = 1L;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }


    public Client(String propFilePath) {
        PropReader inst = PropReader.getInstance();
        this.ip = inst.readFrProp("config.properties","server.ip");
        this.port = inst.intreadfropmProp("config.properties","port");
        scanner = new Scanner(System.in);
    }



    public void start() throws Exception {
        System.out.println("Input username please");
        String name = scanner.nextLine();
        String message;
        while (true){
            System.out.println(" input message");
            message = scanner.nextLine();
            if (!messageAnnaliser(message)) sendAndPrintMessage(SimpleMessage.getMessage(name, message));
        }
    }

    private void sendAndPrintMessage( SimpleMessage message) throws Exception {
        try(Connection connection = new Connection(new Socket(ip,port))){ //gear is autoclosble only becausw without multitherad on server connection must be closed after sending
           connection.sendMessage(message);

           SimpleMessage fromServer= connection.readMessage();
            System.out.println("From Server: "+fromServer); // TODO replace with variable reader.
        }
    }

    private boolean messageAnnaliser(String string){
        string.strip().toLowerCase();


        return false;
    }





}
