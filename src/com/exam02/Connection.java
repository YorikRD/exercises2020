package com.exam02;
//AutoCloseable + close()
//Alows to creat objects in try()

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * No changes to original code
 */
public class Connection implements AutoCloseable {
    // Soclket object allows client to connect server & sever will can reciev
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private static final long serialVersionUID = 2L;

    public Connection(Socket socket) throws IOException {
        this.socket = socket; // sockeet obj common for client & server
        output = new ObjectOutputStream(this.socket.getOutputStream());
        input = new ObjectInputStream(this.socket.getInputStream());
     }
     public void  sendMessage(SimpleMessage2 message) throws IOException {
        message.setDateTime();
        output.writeObject(message); // tranformed to bytes
        output.flush();// forcebly pushed this bytes
     }
     public SimpleMessage2 readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage2) input.readObject();
     }

    @Override // will be callsed automaticaly then try will finish work
    // it will be called automaticaly only in try-with-source construction
    public void close() throws Exception {
        input.close();
        output.close();
        socket.close();
    }
}
