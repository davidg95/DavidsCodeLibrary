/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.JConn;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Thread for handling incoming connections.
 *
 * @author David
 */
public class JConnThread extends Thread {

    private static final Logger LOG = Logger.getGlobal();

    private ObjectInputStream obIn; //InputStream for receiving data.
    private ObjectOutputStream obOut; //OutputStream for sending data

    private final Socket socket; //The main socket

    private boolean conn_term = false;

    private final Semaphore sem; //Semaphore for the output stream.

    /**
     * All the detected method which have the @JConnMethod annotation.
     */
    private final LinkedList<Method> JCONNMETHODS;

    private final Object classToScan;

    /**
     * Constructor for Connection thread.
     *
     * @param name the name of the thread.
     * @param s the socket used for this connection.
     * @param o the class to scan.
     */
    public JConnThread(String name, Socket s, Object o) {
        super(name);
        this.socket = s;
        sem = new Semaphore(1);
        this.classToScan = o;
        JCONNMETHODS = new LinkedList<>();
        scanClass();
    }

    /**
     * Scans this class and finds all method with the JConnMethod annotation.
     */
    private void scanClass() {
        final Method[] methods = classToScan.getClass().getDeclaredMethods(); //Get all the methods in this class
        for (Method m : methods) { //Loop through each method
            if (m.isAnnotationPresent(JConnMethod.class)) { //Check if the annotation is a JConnMethod annotation
                JCONNMETHODS.add(m);
            }
        }
    }

    /**
     * Main run method for the connection thread. This method initialises the
     * input and output streams and performs the client-server handshake. It
     * will check if the connection is allowed and block if it is not. It will
     * then enter a while loop where it will wait for data from the client. It
     * uses reflection to analyse the methods in this class and decides what
     * method to send the request to based on the annotation value and the flag.
     */
    @Override
    public void run() {
        try {
            obIn = new ObjectInputStream(socket.getInputStream());
            obOut = new ObjectOutputStream(socket.getOutputStream());
            obOut.flush();

            while (!conn_term) {
                final JConnData currentData = (JConnData) obIn.readObject();
                try {
                    sem.acquire();
                } catch (InterruptedException ex) {
                    LOG.log(Level.SEVERE, null, ex);
                }

                final JConnData data = currentData.clone(); //Take a clone of the ConnectionData object

                LOG.log(Level.INFO, "Received " + data.getFlag() + " from client", data.getFlag());

                for (Method m : JCONNMETHODS) { //Loop through every method in this class
                    final Annotation a = m.getAnnotation(JConnMethod.class); //Get the JConnMethod annotation
                    if (a.annotationType() == JConnMethod.class) { //Check if it as the JConnMethod annotation
                        final JConnMethod ja = (JConnMethod) a; //Get the JConnMethod annotation object to find out the flag name
                        final String flag = data.getFlag(); //Get the flag from the connection object
                        if (ja.value().equals(flag)) { //Check if the current flag matches the flag definted on the annotation
                            try {
                                final JConnData clone = data.clone(); //Take a clone of the connection data object
                                m.setAccessible(true); //Set the access to public
                                final Runnable run = () -> {
                                    try {
                                        final Object ret = m.invoke(classToScan, clone.getData()); //Invoke the method
                                        obOut.writeObject(JConnData.create("SUCC", ret)); //Return the result
                                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException ex) {
                                        try {
                                            obOut.writeObject(JConnData.create("FAIL", ex));
                                        } catch (IOException ex1) {
                                            Logger.getLogger(JConnThread.class.getName()).log(Level.SEVERE, null, ex1);
                                        }
                                    }
                                };
                                new Thread(run, flag).start(); //Run the thread which will invoke the method
                                break;
                            } catch (IllegalArgumentException ex) {
                                Logger.getLogger(JConnThread.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                sem.release();
            }
            LOG.log(Level.INFO, "Connection closing to client");
        } catch (SocketException ex) {
            LOG.log(Level.WARNING, "The connection to the client was shut down forcefully");
        } catch (IOException | ClassNotFoundException | CloneNotSupportedException | SecurityException ex) {
            System.out.println(ex);
        } finally {
            try {
                socket.close(); //Close the socket
                LOG.log(Level.INFO, "Connection terminated");
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void endConnection(){
        conn_term = true;
    }
}
