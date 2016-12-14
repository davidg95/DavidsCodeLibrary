/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.Utilities;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * Thread which allows you to pass in a JLabal and
 *
 * @author David
 */
public class ClockThread extends Thread {

    private static final ClockThread CLOCK_THREAD;

    protected boolean isRunning;

    protected JLabel dateTimeLabel;
    protected List<JLabel> labels;

    protected SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    protected Time time;

    public ClockThread() {
        labels = new ArrayList<>();
        this.isRunning = true;
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

    /**
     * Gets the current time.
     *
     * @return the current Time.
     */
    public static Time getTime() {
        return CLOCK_THREAD.getCurrentTime();
    }

    @Override
    public void run() {
        while (isRunning) {
            Calendar currentCalendar = Calendar.getInstance();
            Date currentTime = currentCalendar.getTime();
            time = new Time(currentCalendar.getTimeInMillis());
            if (labels != null) {
                SwingUtilities.invokeLater(() -> {
                    for (JLabel label : labels) {
                        label.setText(timeFormat.format(currentTime));
                    }
                });
            }

            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
            }
        }
    }

    public void addLabel(JLabel label) {
        labels.add(label);
    }

    public void removeLabel(JLabel label) {
        labels.remove(label);
    }

    public Time getCurrentTime() {
        return time;
    }

}
