package com.exam02;

import com.exam02.auxiliary.Comands;
import com.exam02.auxiliary.LocalhostOrLan;

import java.io.IOException;
import java.net.Socket;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

/**
 * The most modified class of thiese task
 */
public class ClientMultiThread {
    private String ip;
    private int port;
    private Scanner scanner;
    private static final long serialVersionUID = 1L;
    private Comands comands;
    private int id;



    /**
     * Default constructor allowing to start with any ip or port
     * @param ip
     * @param port
     */
    public ClientMultiThread(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
        this.comands = new Comands("config.properties");
        this.id = this.hashCode();
    }

    /**
     * Constructor working with default variants for running LAN or val Local Host
     * @param choice
     */
    public ClientMultiThread(LocalhostOrLan choice) {
        PropReader inst = PropReader.getInstance();
        String readed = inst.readFrProp(choice.getPath(), choice.getIp());
        System.out.println(readed + " ip");
        this.ip = readed;
        int pr = inst.intreadfropmProp(choice.getPath(), choice.getPort());
        System.out.println(pr + " pr");
        this.port = pr;
        scanner = new Scanner(System.in);
        this.comands = new Comands(choice.getPath());
        this.id = this.hashCode();
    }

    /**
     * The main method calling all others is terminatable via /quit order
     * @throws Exception
     */
    public void start() throws Exception {
        System.out.println("Input username please");
        String name = scanner.nextLine();
        Connection connection = new Connection(new Socket(ip, port));
            System.out.println("connection created");
            connection.sendMessage(SimpleMessage2.getMessage(name+" id of: ~"+id,"connected"));
            new Thread(() ->{
                System.out.println("Thread SenderThread started"+Thread.currentThread() );
                while (true){
                    System.out.println(" input message");
                    String message = scanner.nextLine();
                    if (messageAnnaliser(message) == -1){
                        try {
                            connection.sendMessage(SimpleMessage2.getMessage(name, " leaves the conference"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    if (messageAnnaliser(message) == 0) {
                            try {
                                connection.sendMessage(SimpleMessage2.getMessage(name, message));
                            } catch (IOException e) {
                                e.printStackTrace();
                                return;
                            }
                    }
                }
            }).start();
            new Thread( ()->{
                System.out.println("Thread ReceiverThread started"+Thread.currentThread() );
                while (true){
                     try {
                         SimpleMessage2 fromServer = connection.readMessage();
                         String txt = fromServer.getText();
                         if (txt.startsWith("Time of initial message departure: ")) {
                             txt= txt.replaceFirst("Time of initial message departure: ", "");
                             Duration between = Duration.between(LocalDateTime.parse(txt),LocalDateTime.now());
                             System.out.println("Time between sending request and reciving an anwer is: " + between.toMillis() + " Mills");
                         } else if (txt.equals("leaveCode1")) {
                             connection.close();
                             return;
                         }
                         else{
                             System.out.println("From Server: " + fromServer);
                         }
                     } catch (Exception e) {
                         System.out.println(Thread.currentThread()+ "caused");
                         e.printStackTrace();
                         return;
                     }
                }
            }
            ).start();

    }

    /**
     * Method sending and reading messages from server, responsible for handling /ping order
     * @param message
     * @throws Exception
     */
    private void sendAndPrintMessage(SimpleMessage2 message) throws Exception {
        try (Connection connection = new Connection(new Socket(ip, port))) { //gear is autoclosble only becausw without multitherad on server connection must be closed after sending
            connection.sendMessage(message);

            SimpleMessage2 fromServer = connection.readMessage();
            String txt = fromServer.getText();
            if (txt.startsWith("Time of initial message departure: ")) {
               txt= txt.replaceFirst("Time of initial message departure: ", "");
                Duration between = Duration.between(LocalDateTime.parse(txt),LocalDateTime.now());
                System.out.println("Time between sending request and reciving an anwer is: " + between.toMillis() + " Mills");
            } else{
                System.out.println("From Server: " + fromServer);
            }
        }
    }

    /**
     * Method is responsible for special commands (Clients part)
     * @param string input message
     * @return int triggering sending normal message or special answer
     */
    private int messageAnnaliser(String string) {
        if (comands.getAllcomands().containsKey(string)) {
            switch (string) {
                case "/help":
                    for (Map.Entry<String, String> stringStringEntry : comands.getAllcomands().entrySet()) {
                        System.out.println(stringStringEntry.getValue());
                    }
                    return 1;
                case "/exit":
                    System.out.println("Finishing ClientMultiThread");
                    return -1;

            }
        }
        return 0;
    }
}


