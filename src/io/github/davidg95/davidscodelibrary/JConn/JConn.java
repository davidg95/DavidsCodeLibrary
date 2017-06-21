/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.JConn;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author David
 */
public class JConn {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    /**
     * Method to create a connection to a server.
     *
     * @param ip the IP address to connect to.
     * @param port the port number to connect to.
     * @throws IOException if there was an error connecting.
     */
    public void connect(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        out = new ObjectOutputStream(socket.getOutputStream());
        out.flush();
        in = new ObjectInputStream(socket.getInputStream());
    }

    /**
     * Method to send data to the server.
     *
     * @param data the data to send.
     * @param run the runnable to execute on a successful response.
     * @throws IOException if there was an error sending the data.
     * @throws ClassNotFoundException if there was a class error.
     */
    public void sendData(JConnData data, JConnRunnable run) throws IOException, ClassNotFoundException {
        out.writeObject(data);
        JConnData reply = (JConnData) in.readObject();
        run.run(reply);
    }
}
