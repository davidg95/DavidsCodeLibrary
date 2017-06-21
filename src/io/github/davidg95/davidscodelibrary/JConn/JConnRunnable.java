/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.JConn;

/**
 * Interface which is used for specifying the method to be executed when a reply
 * is sent back.
 *
 * @author David
 */
public interface JConnRunnable {

    /**
     * This method gets run on a reply from the server.
     *
     * @param reply the JConnData object from the server.
     */
    public void run(JConnData reply);
}
