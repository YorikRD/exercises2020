package com.exercisses20;

import com.exercisses20.auxiliary.Comands;
import com.exercisses20.auxiliary.LocalhostOrLan;

import java.net.Socket;
import java.util.Scanner;
import java.util.Set;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;
    private static final long serialVersionUID = 1L;
    Comands comands;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
        this.comands = new Comands("config.properties");
    }


    public Client(LocalhostOrLan choice) {
        PropReader inst = PropReader.getInstance();
        String readed =inst.readFrProp(choice.getPath(),choice.getIp());
        System.out.println(readed +" ip");
        this.ip = readed;
        int pr =inst.intreadfropmProp(choice.getPath(),choice.getPort());
        System.out.println(pr+" pr");
        this.port = pr;
        scanner = new Scanner(System.in);
        this.comands = new Comands(choice.getPath());
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
         if (comands.getAllcomands().containsKey(string)){
             System.out.println(comands.getAllcomands().get(string));
         }
        return false;
    }





}
