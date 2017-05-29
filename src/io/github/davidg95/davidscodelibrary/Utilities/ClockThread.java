/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.Utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * Thread which allows you to pass in a JLabal and
 *
 * @author David
 */
public class ClockThread extends Thread {

    /**
     * The ClockThread object.
     */
    private static final ClockThread CLOCK_THREAD;

    /**
     * The list of labels for the time to get added to.
     */
    private final LinkedList<JLabel> labels;

    /**
     * The Date formatter.
     */
    private final SimpleDateFormat timeFormat;

    public ClockThread() {
        this.timeFormat = new SimpleDateFormat("HH:mm");
        labels = new LinkedList<>();
    }

    static {
        CLOCK_THREAD = new ClockThread();
        CLOCK_THREAD.start();
    }

    /**
     * Method to add a new label to the list of labels to have the time on them.
     *
     * @param label the label to add.
     */
    public static void addClockLabel(JLabel label) {
        CLOCK_THREAD.addLabel(label);
    }

    /**
     * Remove a label from the list.
     *
     * @param label the label to remove.
     */
    public static void removeClockLabel(JLabel label) {
        CLOCK_THREAD.removeLabel(label);
    }

    @Override
    public void run() {
        final Calendar currentCalendar = Calendar.getInstance(); //Get an instance of Calendar.
        while (true) {
            final Date currentTime = currentCalendar.getTime(); //Get the current Date and Time.
            if (labels != null) {
                SwingUtilities.invokeLater(() -> {
                    labels.forEach((label) -> { //Loop through each label.
                        label.setText(timeFormat.format(currentTime)); //Set the current Date and Time on the label.
                    });
                });
            }

            try {
                Thread.sleep(5000L); //Wait 5 seconds before updating again.
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * Adds a new label to the list of labels to have the time assigned to them.
     *
     * @param label the label to add the time to.
     */
    public void addLabel(JLabel label) {
        labels.add(label);
    }

    /**
     * Removes a label from the list of labels to have the time assigned to.
     *
     * @param label the label to remove.
     */
    public void removeLabel(JLabel label) {
        labels.remove(label);
    }
}
