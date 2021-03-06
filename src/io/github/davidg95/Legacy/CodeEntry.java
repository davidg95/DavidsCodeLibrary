/*
 * DavidsCodeLibrary
 * Created by David Grant
 */
package io.github.davidg95.Legacy;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.AbstractAction;
import javax.swing.JDialog;

/**
 * A simple code entry dialog which asks the user to enter a code.
 *
 * @author David
 */
public class CodeEntry extends javax.swing.JDialog {

    private final String CODE; //The code the user must match.
    private static JDialog dialog; //The dialog.
    private String inputValue = ""; //The users input
    private final Runnable run1; //The runnable to execute on successful code entry.
    private final Runnable run2; //The runnable to execute on unsuccessful code entry.
    private static boolean result = false; //The result of the code entry.
    private static String codeResult = ""; //The code the user types in.

    /**
     * Creates new form CodeEntry
     *
     * @param title the title to give to the window.
     * @param CODE the code for this CodeEntry.
     * @param run the runnable to run if the code is entered correctly.
     */
    public CodeEntry(String title, String CODE, Runnable run) {
        this.CODE = CODE;
        this.run1 = run;
        this.run2 = null;
        inputValue = "";
        initComponents();
        init(title);
    }

    /**
     * Creates new form CodeEntry
     *
     * @param title the title to give to the window.
     * @param CODE the code for this CodeEntry.
     * @param run1 the runnable which will be executed if the code is entered
     * correctly.
     * @param run2 the runnable which will be executed if the code is entered
     * incorrectly.
     */
    public CodeEntry(String title, String CODE, Runnable run1, Runnable run2) {
        this.CODE = CODE;
        this.run1 = run1;
        this.run2 = run2;
        inputValue = "";
        initComponents();
        init(title);
    }

    /**
     * Creates new form CodeEntry
     *
     * @param title the title to give to the window.
     * @param CODE the code for this CodeEntry.
     */
    public CodeEntry(String title, String CODE) {
        this.CODE = CODE;
        this.run1 = null;
        this.run2 = null;
        inputValue = "";
        initComponents();
        init(title);
    }

    /**
     * Creates new form CodeEntry
     *
     * @param title the title to give to the window.
     */
    public CodeEntry(String title) {
        this.CODE = null;
        this.run1 = null;
        this.run2 = null;
        inputValue = "";
        initComponents();
        init(title);
    }

    private void init(String title) {
        this.setTitle(title);
        this.setLocationRelativeTo(null);
        this.setModal(true);
    }

    /**
     * Method to show the CodeEntry dialog.
     *
     * @param title the title to show on the window.
     * @param code the code to use. The code the used enters must match this
     * code.
     * @param run the runnable which will be executed if the code is entered
     * correctly.
     */
    @Deprecated
    public static void showCodeEntryDialog(String title, String code, Runnable run) {
        dialog = new CodeEntry(title, code, run);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        dialog.setVisible(true);
    }

    /**
     * Method to show the CodeEntry dialog.
     *
     * @param title the title to show on the window.
     * @param code the code to use. The code the used enters must match this
     * code.
     * @param run1 the runnable which will be executed if the code is entered
     * correctly.
     * @param run2 the runnable which will be executed if the code is entered
     * incorrectly.
     */
    @Deprecated
    public static void showCodeEntryDialog(String title, String code, Runnable run1, Runnable run2) {
        dialog = new CodeEntry(title, code, run1, run2);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        dialog.setVisible(true);
    }

    /**
     * Method to show the CodeEntry dialog.
     *
     * @param title the title to give to the window.
     * @param code the code to use. The code the user enters must match this
     * code.
     * @return true if the code matches, false otherwise. false will also be
     * returned if the user cancels.
     */
    public static boolean showCodeEntryDialog(String title, String code) {
        dialog = new CodeEntry(title, code);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        result = false;
        dialog.setVisible(true);
        return result;
    }

    /**
     * Method to show the CodeEntry dialog.
     *
     * @param title the title to give to the window.
     * @return the code the user entered as a String.
     */
    public static String showCodeEntryDialog(String title) {
        dialog = new CodeEntry(title);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        dialog.setVisible(true);
        return codeResult;
    }

    /**
     * ButtonAction class for the buttons.
     */
    private class ButtonAction extends AbstractAction {

        private static final long serialVersionUID = 1;

        ButtonAction(String text, String actionCommand) {
            super(text);
            init(actionCommand);
        }

        private void init(String actionCommand) {
            putValue(ACTION_COMMAND_KEY, actionCommand);
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
                case "C": //If the user pressed cancel
                    result = false;
                    inputValue = "";
                    if (txtCode.getPassword().length == 0) { //If the text box was empty, then the dialog will get closed.
                        dispose();
                    }
                    txtCode.setText(""); //Clear the text box.
                    break;
                case "Enter": //If the user pressed enter
                    checkCode(); //Check the entered code.
                    break;
                default: //If a number key was pressed
                    inputValue = new String(txtCode.getPassword()); //Get the current text box contents.
                    inputValue += event.getActionCommand(); //Add the number to the end.
                    txtCode.setText(inputValue); //Set the new text box contents.
                    break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        btnEnter = new javax.swing.JButton();
        txtCode = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(320, 320));
        setResizable(false);

        btn1.setText("1");
        btn1.setPreferredSize(new java.awt.Dimension(80, 80));
        btn1.setAction(new ButtonAction("1", "1"));

        btn2.setText("2");
        btn2.setPreferredSize(new java.awt.Dimension(80, 80));
        btn2.setAction(new ButtonAction("2", "2"));

        btn3.setText("3");
        btn3.setPreferredSize(new java.awt.Dimension(80, 80));
        btn3.setAction(new ButtonAction("3", "3"));

        btn4.setText("4");
        btn4.setPreferredSize(new java.awt.Dimension(80, 80));
        btn4.setAction(new ButtonAction("4", "4"));

        btn5.setText("5");
        btn5.setPreferredSize(new java.awt.Dimension(80, 80));
        btn5.setAction(new ButtonAction("5", "5"));

        btn6.setText("6");
        btn6.setPreferredSize(new java.awt.Dimension(80, 80));
        btn6.setAction(new ButtonAction("6", "6"));

        btn7.setText("7");
        btn7.setPreferredSize(new java.awt.Dimension(80, 80));
        btn7.setAction(new ButtonAction("7", "7"));

        btn8.setText("8");
        btn8.setPreferredSize(new java.awt.Dimension(80, 80));
        btn8.setAction(new ButtonAction("8", "8"));

        btn9.setText("9");
        btn9.setPreferredSize(new java.awt.Dimension(80, 80));
        btn9.setAction(new ButtonAction("9", "9"));

        btnC.setText("C");
        btnC.setPreferredSize(new java.awt.Dimension(80, 80));
        btnC.setAction(new ButtonAction("C", "C"));

        btnEnter.setText("Enter");
        btnEnter.setPreferredSize(new java.awt.Dimension(80, 160));
        btnEnter.setAction(new ButtonAction("Enter", "Enter"));

        txtCode.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtCode.setAction(new ButtonAction("", "Enter"));
        txtCode.setPreferredSize(new java.awt.Dimension(320, 40));
        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(txtCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

    /**
     * Method to check the code.
     */
    private void checkCode() {
        if (txtCode.getPassword().length != 0) {
            if (CODE != null) {
                if (Arrays.equals(txtCode.getPassword(), CODE.toCharArray())) { //Check the correct code was entered
                    if (run1 != null) { //Check if a runnable was passed in
                        run1.run();
                    } else {
                        result = true; //If no runnable was passed in then set the result to equal true
                    }
                } else {
                    if (run2 != null) { //Check if a runnable was passed in
                        run2.run();
                    } else {
                        result = false; //If no runnable was passed in then set the result to equal false
                    }
                }
                txtCode.setText("");
                this.dispose();
            } else {
                codeResult = new String(txtCode.getPassword());
            }
        }
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn1;
    public javax.swing.JButton btn2;
    public javax.swing.JButton btn3;
    public javax.swing.JButton btn4;
    public javax.swing.JButton btn5;
    public javax.swing.JButton btn6;
    public javax.swing.JButton btn7;
    public javax.swing.JButton btn8;
    public javax.swing.JButton btn9;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnEnter;
    private javax.swing.JPasswordField txtCode;
    // End of variables declaration//GEN-END:variables
}
