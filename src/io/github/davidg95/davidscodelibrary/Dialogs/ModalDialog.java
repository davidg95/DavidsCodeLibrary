/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.Dialogs;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.print.PrinterJob;
import java.io.Closeable;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 * Class which shows a modal dialog that can be used for showing progress.
 *
 * @author David
 */
public class ModalDialog {

    private JDialog dialog; //The dialog.
    private JPanel panel; //The panel for the components.
    private JLabel label; //The message label.
    private JButton button; //Tje cancel button.

    private final String title; //The title of the window.
    private String text; //The text on the message label.
    private PrinterJob job; //The printer job (if any) associated with this message.
    private boolean hidden;

    private final Component parent; //The parent component.
    private final Closeable close; //The closeable object.

    /**
     * Constructor which creates the dialog.
     *
     * @param parent the parent component.
     * @param title the title.
     * @param text the message.
     */
    public ModalDialog(Component parent, String title, String text) {
        this(parent, title, text, null);
    }

    /**
     * Constructor which creates the dialog.
     *
     * @param parent the parent component.
     * @param title the title.
     * @param text the message.
     * @param close the closeable object.
     */
    public ModalDialog(Component parent, String title, String text, Closeable close) {
        this.title = title;
        this.text = text;
        this.hidden = false;
        this.parent = parent;
        this.close = close;
        init();
    }

    private void init() {
        panel = new JPanel();
        label = new JLabel(text);
        button = new JButton("Cancel");
        button.addActionListener((ActionEvent e) -> {
            try {
                if (close != null) {
                    close.close();
                }
                hide();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(dialog, "Object could not close", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        final Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        panel.add(label);
        panel.setBorder(padding);
        dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        dialog.setModal(true);
        dialog.setResizable(false);
        dialog.setTitle(title);
        dialog.setContentPane(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(parent);
        dialog.revalidate();
    }

    /**
     * Changes the text on the dialog. This method makes a call to
     * <code>SwingUtilities.invokeLater()</code>.
     *
     * @param text the new text.
     */
    public void setText(String text) {
        this.text = text;
        SwingUtilities.invokeLater(() -> {
            label.setText(text);
        });
    }

    /**
     * Method to show the dialog.
     */
    public void show() {
        if (!hidden) {
            dialog.setVisible(true);
        }
    }

    /**
     * Method to hide the dialog.
     */
    public void hide() {
        this.hidden = true;
        dialog.setVisible(false);
    }

}
