/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.JConn;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Thread which accepts incoming connections from clients.
 *
 * @author David
 */
public class JConnConnectionAccept extends Thread {

    private static final Logger LOG = Logger.getGlobal();

    /**
     * The port which is being used by the server.
     */
    public static int PORT_IN_USE;

    /**
     * The maximum number of connections that can be active at once. This must
     * be changed before starting the thread.
     */
    public static int MAX_CONN = 10;

    /**
     * The maximum number of connections that can be queued, This must be
     * changed before starting the thread.
     */
    public static int MAX_QUEUE = 10;

    private final ServerSocket socket;

    private final Object classToScan;

    /**
     * Constructor which starts the ThreadPoolExcecutor.
     *
     * @param PORT the port number to listen on.
     * @param classToScan
     * @throws IOException if there was a network error.
     */
    public JConnConnectionAccept(int PORT, Object classToScan) throws IOException {
        super("ConnectionAcceptThread");
        this.socket = new ServerSocket(PORT);
        this.classToScan = classToScan;
        PORT_IN_USE = PORT;
    }

    @Override
    public void run() {
        LOG.log(Level.INFO, "Starting Thread Pool Excecutor");
        final ThreadPoolExecutor pool = new ThreadPoolExecutor(MAX_CONN, MAX_QUEUE, 50000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(MAX_QUEUE));
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            LOG.log(Level.INFO, "Local IP address is " + InetAddress.getLocalHost().getHostAddress());
            LOG.log(Level.INFO, "Server Socket running on port number " + PORT_IN_USE);
        } catch (UnknownHostException ex) {
            LOG.log(Level.WARNING, "For some reason, the ip address of the local server could not be retrieved");
        }
        LOG.log(Level.INFO, "Ready to accept connections");
        for (;;) {
            try {
                final Socket incoming = socket.accept(); //Wait for a connection.
                final JConnThread th = new JConnThread(socket.getInetAddress().getHostAddress(), incoming, classToScan);
                pool.submit(th); //Submit the socket to the excecutor.
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
        }
    }
}
