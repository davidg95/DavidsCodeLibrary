/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.Dialogs;

import javax.swing.JDialog;

/**
 * BigPrompt Dialog which displays a dialog designed to be big enough for touch
 * screen displays.
 *
 * @author David
 */
public class BigPromptOld extends javax.swing.JDialog {

    private static JDialog dialog;
    private static String result;
    private static boolean input = false;

    /**
     * Creates new form BigPrompt
     *
     * @param title the title to add to the window.
     * @param message the message to display in the window.
     */
    public BigPromptOld(String title, String message) {
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
        dialog = new BigPromptOld(title, message);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
    
    public static String showInputDialog(String title, String message){
        input = true;
        dialog = new BigPromptOld(title, message);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        result = null;
        dialog.setVisible(true);
        return result;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMessage = new javax.swing.JLabel();
        txtOK = new javax.swing.JButton();
        txtInput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        txtOK.setText("OK");
        txtOK.setPreferredSize(new java.awt.Dimension(100, 100));
        txtOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOKActionPerformed(evt);
            }
        });

        txtInput.setFont(new java.awt.Font("Tahoma", 0, 27)); // NOI18N
        txtInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtOK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtInput, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtInput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOKActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_txtOKActionPerformed

    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        txtOK.doClick();
    }//GEN-LAST:event_txtInputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMessage;
    private javax.swing.JTextField txtInput;
    private javax.swing.JButton txtOK;
    // End of variables declaration//GEN-END:variables
}
