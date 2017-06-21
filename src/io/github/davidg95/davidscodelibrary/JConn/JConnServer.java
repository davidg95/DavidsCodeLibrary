/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.JConn;

import java.io.IOException;

/**
 *
 * @author David
 */
public class JConnServer {

    private static boolean started = false;

    public static void start(int port, Object classToScan) throws IOException {
        if (started) {
            throw new IOException("JConn has already been started");
        }
        JConnConnectionAccept thread = new JConnConnectionAccept(port, classToScan);
        thread.start();
        started = true;
    }
}
