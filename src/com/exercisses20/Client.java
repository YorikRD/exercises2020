package com.exercisses20;

import com.exam01.PersonalData;
import com.exercisses20.auxiliary.Comands;
import com.exercisses20.auxiliary.LocalhostOrLan;

import java.net.Socket;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalUnit;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * The most modified class of thiese task
 */
public class Client {
    private String ip;
    private int port;
    private Scanner scanner;
    private static final long serialVersionUID = 1L;
    Comands comands;

    /**
     * Default constructor allowing to start with any ip or port
     * @param ip
     * @param port
     */
    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
        this.comands = new Comands("config.properties");
    }

    /**
     * Constructor working with default variants for running LAN or val Local Host
     * @param choice
     */
    public Client(LocalhostOrLan choice) {
        PropReader inst = PropReader.getInstance();
        String readed = inst.readFrProp(choice.getPath(), choice.getIp());
        System.out.println(readed + " ip");
        this.ip = readed;
        int pr = inst.intreadfropmProp(choice.getPath(), choice.getPort());
        System.out.println(pr + " pr");
        this.port = pr;
        scanner = new Scanner(System.in);
        this.comands = new Comands(choice.getPath());
    }

    /**
     * The main method calling all others is terminatable via /quit order
     * @throws Exception
     */
    public void start() throws Exception {
        System.out.println("Input username please");
        String name = scanner.nextLine();
        String message;
        while (true) {
            System.out.println(" input message");
            message = scanner.nextLine();
            if (messageAnnaliser(message) == -1) break;
            if (messageAnnaliser(message) == 0) sendAndPrintMessage(SimpleMessage.getMessage(name, message));
        }
    }

    /**
     * Method sending and reading messages from server, responsible for handling /ping order
     * @param message
     * @throws Exception
     */
    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(new Socket(ip, port))) { //gear is autoclosble only becausw without multitherad on server connection must be closed after sending
            connection.sendMessage(message);

            SimpleMessage fromServer = connection.readMessage();
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
