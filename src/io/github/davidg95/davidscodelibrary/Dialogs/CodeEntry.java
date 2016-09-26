/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.Dialogs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 * Dialog which displays a number entry form.
 *
 * @author David
 */
public class CodeEntry extends JDialog {

    private String CODE;
    private static JDialog dialog;
    private JPanel keyPanel;
    private String inputValue;
    private static boolean result;
    private static String codeResult;
    private JTextComponent codeField;

    /**
     * Creates new form CodeEntry
     *
     * @param title the title to give to the window.
     * @param CODE the code for this CodeEntry.
     * @param hideCode true if you want a password field, false if you want a
     * normal text field.
     */
    public CodeEntry(String title, String CODE, boolean hideCode) {
        this(title, hideCode);
        this.CODE = CODE;
    }

    /**
     * Creates new form CodeEntry
     *
     * @param title the title to give to the window.
     * @param hideCode true if you want a password field, false if you want a
     * normal text field.
     */
    public CodeEntry(String title, boolean hideCode) {
        if (hideCode) {
            codeField = new JPasswordField();
        } else {
            codeField = new JTextField();
        }
        createGUI();
        this.setTitle(title);
        this.setLocationRelativeTo(null);
        this.setModal(true);
    }

    public final void createGUI() {
        keyPanel = new JPanel();
        keyPanel.setLayout(new GridLayout(4, 3));
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setResizable(false);
        setMinimumSize(new java.awt.Dimension(240, 400));
        setMaximumSize(new java.awt.Dimension(240, 400));
        setPreferredSize(new java.awt.Dimension(240, 400));
        keyPanel.setMinimumSize(new java.awt.Dimension(240, 320));
        keyPanel.setMaximumSize(new java.awt.Dimension(240, 320));
        keyPanel.setPreferredSize(new java.awt.Dimension(240, 320));
        inputValue = "";
        codeField.setFont(new java.awt.Font("Tahoma", 0, 36));
        codeField.setPreferredSize(new java.awt.Dimension(240, 50));
        codeField.setMinimumSize(new java.awt.Dimension(240, 50));
        codeField.setMaximumSize(new java.awt.Dimension(240, 50));
        if (codeField instanceof JPasswordField) {
            JPasswordField passField = (JPasswordField) codeField;
            passField.addActionListener((java.awt.event.ActionEvent evt) -> {
                checkCode();
            });
            add(passField);
        } else {
            JTextField field = (JTextField) codeField;
            field.addActionListener((java.awt.event.ActionEvent evt) -> {
                checkCode();
            });
            add(field);
        }
        addButton("1");
        addButton("2");
        addButton("3");
        addButton("4");
        addButton("5");
        addButton("6");
        addButton("7");
        addButton("8");
        addButton("9");
        addButton("C");
        addButton("0");
        addButton("Enter");
        add(keyPanel);
        pack();
    }

    public final void addButton(String value) {
        JButton button = new JButton();
        button.setText(value);
        button.setPreferredSize(new java.awt.Dimension(80, 80));
        button.setMinimumSize(new java.awt.Dimension(80, 80));
        button.setMaximumSize(new java.awt.Dimension(80, 80));
        button.setAction(new ButtonAction(value, value));
        keyPanel.add(button);
    }

    private class ButtonAction extends AbstractAction {

        private static final long serialVersionUID = 1;

        ButtonAction(String text, String actionCommand) {
            super(text);
            putValue(ACTION_COMMAND_KEY, actionCommand);
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
                case "C": //If the user pressed cancel
                    result = false;
                    inputValue = "";
                    if (codeField instanceof JPasswordField) {
                        JPasswordField passField = (JPasswordField) codeField;
                        if (passField.getPassword().length == 0) {
                            dispose();
                        }
                    } else {
                        JTextField field = (JTextField) codeField;
                        if (field.getText().length() == 0) {
                            dispose();
                        }
                    }
                    codeField.setText("");
                    break;
                case "Enter": //If the user pressed enter
                    checkCode();
                    break;
                default: //If a number key was pressed
                    if (codeField instanceof JPasswordField) {
                        JPasswordField passField = (JPasswordField) codeField;
                        inputValue = new String(passField.getPassword());
                    } else {
                        JTextField field = (JTextField) codeField;
                        inputValue = field.getText();
                    }
                    inputValue += event.getActionCommand();
                    codeField.setText(inputValue);
                    break;
            }
        }
    }

    /**
     * Method to show the CodeEntry dialog.
     *
     * @param title the title to give to the window.
     * @param code the code to use. The code the user enters must match this
     * code.
     * @param hideCode true if you want a password field, false if you want a
     * normal text field.
     * @return true if the code matches, false otherwise. false will also be
     * returned if the user cancels.
     */
    public static boolean showCodeEntryDialog(String title, String code, boolean hideCode) {
        dialog = new CodeEntry(title, code, hideCode);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        result = false;
        dialog.setVisible(true);
        return result;
    }

    /**
     * Method to show the CodeEntry dialog.
     *
     * @param title the title to give to the window.
     * @param hideCode true if you want a password field, false if you want a
     * normal text field.
     * @return the code the user entered as a String.
     */
    public static String showCodeEntryDialog(String title, boolean hideCode) {
        dialog = new CodeEntry(title, hideCode);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        codeResult = "";
        dialog.setVisible(true);
        return codeResult;
    }

    /**
     * Method to check the code.
     */
    private void checkCode() {
        if (codeField instanceof JPasswordField) {
            JPasswordField passField = (JPasswordField) codeField;
            if (passField.getPassword().length != 0) {
                if (CODE != null) {
                    result = Arrays.equals(passField.getPassword(), CODE.toCharArray()); //Check the correct code was entered
                    passField.setText("");
                    this.dispose();
                } else {
                    codeResult = new String(passField.getPassword());
                }
            }
        } else {
            JTextField field = (JTextField) codeField;
            if (field.getText().length() != 0) {
                if (CODE != null) {
                    result = field.getText().equals(CODE); //Check the correct code was entered
                    field.setText("");
                    this.dispose();
                } else {
                    codeResult = field.getText();
                }
            }
        }
        this.dispose();
    }
}
