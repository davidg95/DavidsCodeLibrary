/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary.Buttons;

import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleState;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.DefaultButtonModel;
import javax.swing.JToggleButton;

/**
 *
 * @author David
 */
public class JSwitch extends AbstractButton implements Accessible {

    private BufferedImage img_on;
    private BufferedImage img_off;

    private boolean state = false;

    private static final String UICLASSID = "SwitchUI";

    public JSwitch() {
        this(false);
    }

    public JSwitch(Action a) {
        this();
        setAction(a);
    }

    public JSwitch(boolean selected) {
        super();
        state = selected;
        this.setModel(new JSwitchModel());
//        enableInputMethods(true);
//        addMouseListener(this);
        try {
            img_on = ImageIO.read(getClass().getClassLoader().getResource("resources/switch_on.jpg"));
            img_off = ImageIO.read(getClass().getClassLoader().getResource("resources/switch_off.jpg"));
            super.setSize(new Dimension(this.img_on.getWidth(), this.img_on.getHeight()));
        } catch (IOException e) {
        }

        init(null, null);
    }

    private void setOn(boolean on) {
        state = on;
        repaint();
    }

    @Override
    public String getUIClassID() {
        return UICLASSID;
    }

    @Override
    public void updateUI() {
        setUI(null);
    }

    boolean shouldUpdateSelectedStateFromAction() {
        return true;
    }

    @Override
    public void setSize(Dimension d) {
        super.setSize(new Dimension(this.img_on.getWidth(), this.img_on.getHeight()));
    }

    @Override
    public Dimension getSize() {
        return new Dimension(this.img_on.getWidth(), this.img_on.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!state) {
            g.drawImage(img_off, this.getX(), this.getY(), this);
        } else {
            g.drawImage(img_on, this.getX(), this.getY(), this);
        }
    }

    /**
     * Returns a string representation of this JToggleButton. This method is
     * intended to be used only for debugging purposes, and the content and
     * format of the returned string may vary between implementations. The
     * returned string may be empty but may not be <code>null</code>.
     *
     * @return a string representation of this JToggleButton.
     */
    @Override
    protected String paramString() {
        return super.paramString();
    }

    // *********************************************************************
    /**
     * The ToggleButton model
     * <p>
     * <strong>Warning:</strong>
     * Serialized objects of this class will not be compatible with future Swing
     * releases. The current serialization support is appropriate for short term
     * storage or RMI between applications running the same version of Swing. As
     * of 1.4, support for long term storage of all JavaBeans&trade; has been
     * added to the <code>java.beans</code> package. Please see
     * {@link java.beans.XMLEncoder}.
     */
    public static class JSwitchModel extends DefaultButtonModel {

        /**
         * Creates a new ToggleButton Model
         */
        public JSwitchModel() {
        }

        /**
         * Checks if the button is selected.
         *
         * @return if it is selected or not.
         */
        @Override
        public boolean isSelected() {
            return (stateMask & SELECTED) != 0;
        }

        /**
         * Sets the selected state of the button.
         *
         * @param b true selects the toggle button, false deselects the toggle
         * button.
         */
        @Override
        public void setSelected(boolean b) {

            if (isSelected() == b) {
                return;
            }

            if (b) {
                stateMask |= SELECTED;
            } else {
                stateMask &= ~SELECTED;
            }

            // Send ChangeEvent
            fireStateChanged();

            // Send ItemEvent
            fireItemStateChanged(
                    new ItemEvent(this,
                            ItemEvent.ITEM_STATE_CHANGED,
                            this,
                            this.isSelected() ? ItemEvent.SELECTED : ItemEvent.DESELECTED));

        }

        /**
         * Sets the pressed state of the toggle button.
         *
         * @param b set whether the toggle button is pressed or not.
         */
        @Override
        public void setPressed(boolean b) {
            if ((isPressed() == b) || !isEnabled()) {
                return;
            }

            if (b == false && isArmed()) {
                setSelected(!this.isSelected());
            }

            if (b) {
                stateMask |= PRESSED;
            } else {
                stateMask &= ~PRESSED;
            }

            fireStateChanged();

            if (!isPressed() && isArmed()) {
                int modifiers = 0;
                AWTEvent currentEvent = EventQueue.getCurrentEvent();
                if (currentEvent instanceof InputEvent) {
                    modifiers = ((InputEvent) currentEvent).getModifiers();
                } else if (currentEvent instanceof ActionEvent) {
                    modifiers = ((ActionEvent) currentEvent).getModifiers();
                }
                fireActionPerformed(
                        new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
                                getActionCommand(),
                                EventQueue.getMostRecentEventTime(),
                                modifiers));
            }

        }
    }
/////////////////
// Accessibility support
////////////////

    /**
     * Gets the AccessibleContext associated with this JToggleButton. For toggle
     * buttons, the AccessibleContext takes the form of an
     * AccessibleJToggleButton. A new AccessibleJToggleButton instance is
     * created if necessary.
     *
     * @return an AccessibleJToggleButton that serves as the AccessibleContext
     * of this JToggleButton
     * this ToggleButton.
     */
    @Override
    public AccessibleContext getAccessibleContext() {
        if (accessibleContext == null) {
            accessibleContext = new AccessibleJSwitch();
        }
        return accessibleContext;
    }

    /**
     * This class implements accessibility support for the
     * <code>JToggleButton</code> class. It provides an implementation of the
     * Java Accessibility API appropriate to toggle button user-interface
     * elements.
     * <p>
     * <strong>Warning:</strong>
     * Serialized objects of this class will not be compatible with future Swing
     * releases. The current serialization support is appropriate for short term
     * storage or RMI between applications running the same version of Swing. As
     * of 1.4, support for long term storage of all JavaBeans&trade; has been
     * added to the <code>java.beans</code> package. Please see
     * {@link java.beans.XMLEncoder}.
     */
    protected class AccessibleJSwitch extends AccessibleAbstractButton
            implements ItemListener {

        public AccessibleJSwitch() {
            super();
            JSwitch.this.addItemListener(this);
        }

        /**
         * Fire accessible property change events when the state of the toggle
         * button changes.
         *
         * @param e the event.
         */
        @Override
        public void itemStateChanged(ItemEvent e) {
            JToggleButton tb = (JToggleButton) e.getSource();
            if (JSwitch.this.accessibleContext != null) {
                if (tb.isSelected()) {
                    JSwitch.this.accessibleContext.firePropertyChange(
                            AccessibleContext.ACCESSIBLE_STATE_PROPERTY,
                            null, AccessibleState.CHECKED);
                } else {
                    JSwitch.this.accessibleContext.firePropertyChange(
                            AccessibleContext.ACCESSIBLE_STATE_PROPERTY,
                            AccessibleState.CHECKED, null);
                }
            }
        }

        /**
         * Get the role of this object.
         *
         * @return an instance of AccessibleRole describing the role of the
         * object
         */
        @Override
        public AccessibleRole getAccessibleRole() {
            return AccessibleRole.TOGGLE_BUTTON;
        }
    } // inner class AccessibleJToggleButton

}
