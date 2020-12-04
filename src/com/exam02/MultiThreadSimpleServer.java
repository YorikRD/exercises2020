package com.exam02;

import com.exam02.auxiliary.LocalhostOrLan;
import com.exam02.auxiliary.PropReader;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @private ConcurrentSkipListMap<Integer, Connection> connections - main map with a key of client id and value of
 * connection with it.
 * @private LinkedBlockingQueue<SimpleMessage2> forSend an queue of messages ready for send by single SenderThread.
 * @private ExecutorService requestDeallers - ThreadPool responsible for analise messages from clients
 */
class MultiThreadSimpleServer {
    private ConcurrentSkipListMap<Integer, Connection> connections = new ConcurrentSkipListMap<>(); // Map sorted by key
    private static final long serialVersionUID = 2L;
    private LinkedBlockingQueue<SimpleMessage2> forSend = new LinkedBlockingQueue<>();
    private ExecutorService requestDeallers = new ThreadPoolExecutor(2,
            Runtime.getRuntime().availableProcessors(),
            250,TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(1200));
    private CopyOnWriteArrayList<String> clients = new CopyOnWriteArrayList();
    /**
     * Declaration and inicialisation of senderThread & main reciverThread (creates readerthreads for all incomming threads)
     * @param choice Choice between enum values generate keys for config.properties
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void start(LocalhostOrLan choice) throws IOException, ClassNotFoundException {
        PropReader inst = PropReader.getInstance();
        new SenderThread().start();
        System.out.println("Server Started variant: " + choice + " with port: " + choice.getPort());
        Thread maireciverThread = new Thread(() -> {
            while (true) {
                try (ServerSocket serverSocket = new ServerSocket(inst.intreadfropmProp(choice.getPath(), choice.getPort()))) { // waiting for clients
                    Socket socket = serverSocket.accept();
                    Connection connection = new Connection(socket);
                    SimpleMessage2 newM = connection.readMessage();
                    connections.putIfAbsent(newM.getSenderId(), connection);
                    System.out.println("connection establiched added " + newM.getSenderId() + '\n' + " the connections is " + connections);
                    new ReaderThread(connection).start();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        maireciverThread.start();
    }


    public static void main(String[] args) {
        MultiThreadSimpleServer server = new MultiThreadSimpleServer();
        try {
            server.start(LocalhostOrLan.LOCALHOST);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * private inner class responsible for variable dealing with Clients request
     * creates and adds to the @forsend queue messages addressed either for original sender, or all other clients.
     * upon receiving message with leving request, removes from client list and creates two messages, one for original
     * sender triggering th termination of its reader thread, and the other to all others.
     */
    private class RequestWorker implements Runnable {
        SimpleMessage2 source;
        public RequestWorker(SimpleMessage2 source) {
            this.source = source;
        }
        @Override
        public void run() {
            SimpleMessage2 answer = null;
            String string = null;
            switch (source.getText()) {
                case "/count":
                    string = "Current number of unique Logins is: " + connections.size();
                    answer=SimpleMessage2.getMessage("server",string,source.getSenderId());
                    break;
                case "/ping":
                    string = "Time of initial message departure: " + source.getDateTime();
                    answer=SimpleMessage2.getMessage("server",string,source.getSenderId());
                    break;
                case " leaves the conference":
                    string = "leaveCode1";
                    answer=SimpleMessage2.getMessage("server",string,source.getSenderId());
                    clients.remove(source.getSender());
                    try {
                        forSend.put(SimpleMessage2.getMessage(source.getSender(),"Leaved the conference",source.getSenderId()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                case "/list":
                    string = clients.toString();
                    answer=SimpleMessage2.getMessage("server",string,source.getSenderId());
                    break;
                default:
                    string = source.getText();
                    answer=SimpleMessage2.getMessage(source.getSender(),string,source.getSenderId());
            }
            try {
                forSend.put(answer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Inner class responsible for sending messages to either all connections except original sender
     * or only the original sender
     * responsible for removing leaving client from Map with active ones& closing its connection.
     * */
    private class SenderThread extends Thread {

        @Override
        public void run() {
            SimpleMessage2 sending = null;
            while (true){
                try {
                    sending = forSend.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    if (sending.getSender().equals("server")) {
                        connections.get(sending.getSenderId()).sendMessage(sending);
                        if (sending.getText().equals("leaveCode1")){
                            connections.get(sending.getSenderId()).close();
                            connections.remove(sending.getSenderId());
                        }
                    } else {
                        for (Integer integer : connections.keySet()) {
                            if (integer != sending.getSenderId()) connections.get(integer).sendMessage(sending);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Inner class responsible from reading from single
     * automaticaly finishes its work upon receiving leaving request
     */
    private class ReaderThread extends Thread {
        private Connection connection;

        public ReaderThread(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while (true) {
                SimpleMessage2 newM = null;
                try {
                    newM = connection.readMessage();
                    clients.addIfAbsent(newM.getSender());
                    requestDeallers.execute(new RequestWorker(newM));
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println(newM);
                if (newM.getText().equals(" leaves the conference")) {
                    System.out.println("Readerthread to this connection closed");
                    return;
                }
            }
        }
    }
}

