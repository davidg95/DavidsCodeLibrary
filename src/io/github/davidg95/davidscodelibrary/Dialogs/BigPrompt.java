/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.Dialogs;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * BigPrompt Dialog which displays a dialog designed to be big enough for touch
 * screen displays.
 *
 * @author David
 */
public class BigPrompt extends JDialog {

    private static JDialog dialog;
    private static String result;
    private static boolean isInput = false;

    /**
     * Creates new form BigPrompt
     *
     * @param title the title to add to the window.
     * @param message the message to display in the window.
     */
    public BigPrompt(String title, String message) {
        initComponents();
        this.setTitle(title);
        this.lblMessage.setText(message);
        this.setLocationRelativeTo(null);
        this.setModal(true);
    }

    /**
     * Displays the dialog.
     *
     * @param title the title for the window.
     * @param message the message to display on the window.
     */
    public static void showMessageDialog(String title, String message) {
        dialog = new BigPrompt(title, message);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    /**
     * Displays the input dialog.
     *
     * @param title the title for the window.
     * @param message the message to display on the window.
     * @return the String entered by the user.
     */
    public static String showInputDialog(String title, String message) {
        isInput = true;
        dialog = new BigPrompt(title, message);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        result = null;
        dialog.setVisible(true);
        return result;
    }

    private void initComponents() {
        lblMessage = new JLabel();
        btnOK = new JButton();

        this.setResizable(false);

        btnOK.setText("OK");
        btnOK.setPreferredSize(new Dimension(400, 100));
        btnOK.addActionListener((ActionEvent evt) -> {
            btnOKActionPerformed();
        });
        
        lblMessage.setPreferredSize(new Dimension(230, 20));

        this.add(lblMessage);
        if (isInput) {
            txtInput = new JTextField();
            txtInput.setFont(new Font("Tahoma", 0, 27));
            txtInput.addActionListener((ActionEvent evt) -> {
                txtInputActionPerformed();
            });
            this.add(txtInput);
        }
        
        this.add(btnOK);
        
        pack();
    }

    private void btnOKActionPerformed() {
        this.setVisible(false);
    }
    
    private void txtInputActionPerformed(){
        btnOK.doClick();
    }

    private JLabel lblMessage;
    private JButton btnOK;
    private JTextField txtInput;
}
