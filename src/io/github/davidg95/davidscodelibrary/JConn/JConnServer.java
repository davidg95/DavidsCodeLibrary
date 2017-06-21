/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.JConn;

import java.io.IOException;

/**
 * Class which start the server.
 *
 * @author David
 */
public class JConnServer {

    /**
     * Indicates whether the server has been started or not.
     */
    private static boolean started = false;

    /**
     * Indicates if log output should be included.
     */
    protected static final boolean DEBUG = false;

    /**
     * Start a new instance of JConnServer on the specified port.
     *
     * @param port the port to listen on.
     * @param classToScan the class to scan for annotations on methods.
     * @throws IOException if there was an error ins starting the server.
     */
    public static void start(int port, Object classToScan) throws IOException {
        start(port, classToScan, false);
    }

    /**
     * Start a new instance of JConnServer on the specified port.
     *
     * @param port the port to listen on.
     * @param classToScan the class to scan for annotations on methods.
     * @param debug indicates if log output should be included.
     * @throws IOException if there was an error ins starting the server.
     */
    public static void start(int port, Object classToScan, boolean debug) throws IOException {
        if (started) {
            throw new IOException("JConn has already been started");
        }
        JConnConnectionAccept thread = new JConnConnectionAccept(port, classToScan);
        thread.start();
        started = true;
    }
}
