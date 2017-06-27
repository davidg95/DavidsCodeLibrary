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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for sending JConn requests to a JConn server.
 *
 * @author David
 */
public class JConn {

    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    private final HashMap<String, JConnRunnable> incomingQueue;
    private IncomingThread inc;
    private final JConnRunnable run;

    /**
     * Creates a new JConn object.
     *
     * @param run the runnable to execute when an unknown flag is received from
     * the server.
     */
    public JConn(JConnRunnable run) {
        incomingQueue = new HashMap<>();
        this.run = run;
    }

    private class IncomingThread extends Thread {

        private final ObjectInputStream in;
        private boolean run;
        private final JConnRunnable runner;

        private IncomingThread(ObjectInputStream in, JConnRunnable runner) {
            this.in = in;
            run = true;
            this.runner = runner;
        }

        @Override
        public void run() {
            while (run) {
                try {
                    final JConnData data = (JConnData) in.readObject();
                    final String flag = data.getFlag();
                    boolean found = false;
                    for (Map.Entry me : incomingQueue.entrySet()) {
                        if (me.getKey().equals(flag)) {
                            ((JConnRunnable) me.getValue()).run(data);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        runner.run(data);
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(JConn.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        private void stopRun() {
            run = false;
        }
    }

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
        inc = new IncomingThread(in, run);
        inc.start();
    }

    /**
     * Method to send data to the server.
     *
     * @param data the data to send.
     * @param run the runnable to execute on a successful response.
     * @throws IOException if there was an error sending the data.
     */
    public void sendData(JConnData data, JConnRunnable run) throws IOException {
        out.writeObject(data);
        JConnData reply;
        final ReturnData returnData = new ReturnData();
        final JConnRunnable runnable = (tempReply) -> {
            returnData.object = tempReply;
            returnData.cont = true;
        };
        incomingQueue.put(data.getFlag(), runnable);
        try {
            while (!returnData.cont) {
                Thread.sleep(50);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(JConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        reply = (JConnData) returnData.object;
        run.run(reply);
    }

    /**
     * Method to send data to the server.
     *
     * @param data the data to send.
     * @return the data that was returned.
     * @throws IOException if there was an error sending the data.
     */
    public JConnData sendData(JConnData data) throws IOException {
        out.writeObject(data);
        JConnData reply;
        final ReturnData returnData = new ReturnData();
        final JConnRunnable runnable = (tempReply) -> {
            returnData.object = tempReply;
            returnData.cont = true;
        };
        incomingQueue.put(data.getFlag(), runnable);
        try {
            while (!returnData.cont) {
                Thread.sleep(50);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(JConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        reply = (JConnData) returnData.object;
        return reply;
    }

    private class ReturnData {

        private Object object;
        private boolean cont = false;
    }
}
