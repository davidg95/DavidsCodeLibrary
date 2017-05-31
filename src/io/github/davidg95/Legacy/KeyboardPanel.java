/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.Legacy;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author David
 */
public class KeyboardPanel extends JPanel {

    private final Component parent;
    private final JTextField field;

    /**
     * Creates new form Keyboard
     *
     * @param parent the parent component.
     * @param field the field to enter the text into.
     */
    public KeyboardPanel(Component parent, JTextField field) {
        this.parent = parent;
        this.field = field;
        initComponents();
    }

    private class ButtonAction extends AbstractAction {

        private boolean uppercase = false;
        private static final long serialVersionUID = 1;

        ButtonAction(String text, String actionCommand) {
            super(text);
            init(actionCommand);
        }

        private void init(String actionCommand) {
            putValue(ACTION_COMMAND_KEY, actionCommand);

        }

        public void onEnter() {

        }

        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
                case "BACKSPACE":
                    field.setText(field.getText().substring(0, field.getText().length() - 1));
                    break;
                case "ENTER":
                    onEnter();
                    break;
                case "TAB":
                    append("    ");
                    break;
                case "SHIFT":
                    uppercase = !uppercase;
                    rshift.setSelected(uppercase);
                    lshift.setSelected(uppercase);
                    break;
                default:
                    append(event.getActionCommand());
                    break;
            }
        }

        private void append(String t) {
            if (uppercase) {
                field.setText(field.getText() + t);
            } else {
                field.setText(field.getText() + t.toLowerCase());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        keyboardPanel = new javax.swing.JPanel();
        q = new javax.swing.JButton();
        a = new javax.swing.JButton();
        z = new javax.swing.JButton();
        x = new javax.swing.JButton();
        s = new javax.swing.JButton();
        w = new javax.swing.JButton();
        e = new javax.swing.JButton();
        d = new javax.swing.JButton();
        c = new javax.swing.JButton();
        r = new javax.swing.JButton();
        f = new javax.swing.JButton();
        v = new javax.swing.JButton();
        t = new javax.swing.JButton();
        g = new javax.swing.JButton();
        b = new javax.swing.JButton();
        y = new javax.swing.JButton();
        h = new javax.swing.JButton();
        n = new javax.swing.JButton();
        u = new javax.swing.JButton();
        j = new javax.swing.JButton();
        m = new javax.swing.JButton();
        i = new javax.swing.JButton();
        k = new javax.swing.JButton();
        comma = new javax.swing.JButton();
        o = new javax.swing.JButton();
        l = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        p = new javax.swing.JButton();
        backspace = new javax.swing.JButton();
        enter = new javax.swing.JButton();
        rshift = new javax.swing.JToggleButton();
        lshift = new javax.swing.JToggleButton();
        space = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        if (parent instanceof JFrame) {
            JFrame frameParent = (JFrame) parent;
            frameParent.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        }

        keyboardPanel.setMaximumSize(new java.awt.Dimension(1024, 32767));
        keyboardPanel.setMinimumSize(new java.awt.Dimension(1024, 0));

        q.setText("Q");
        q.setMaximumSize(new java.awt.Dimension(85, 85));
        q.setMinimumSize(new java.awt.Dimension(85, 85));
        q.setPreferredSize(new java.awt.Dimension(85, 85));

        a.setText("A");
        a.setMaximumSize(new java.awt.Dimension(85, 85));
        a.setMinimumSize(new java.awt.Dimension(85, 85));
        a.setPreferredSize(new java.awt.Dimension(85, 85));

        z.setText("Z");
        z.setMaximumSize(new java.awt.Dimension(85, 85));
        z.setMinimumSize(new java.awt.Dimension(85, 85));
        z.setPreferredSize(new java.awt.Dimension(85, 85));

        x.setText("X");
        x.setMaximumSize(new java.awt.Dimension(85, 85));
        x.setMinimumSize(new java.awt.Dimension(85, 85));
        x.setPreferredSize(new java.awt.Dimension(85, 85));

        s.setText("S");
        s.setMaximumSize(new java.awt.Dimension(85, 85));
        s.setMinimumSize(new java.awt.Dimension(85, 85));
        s.setPreferredSize(new java.awt.Dimension(85, 85));

        w.setText("W");
        w.setMaximumSize(new java.awt.Dimension(85, 85));
        w.setMinimumSize(new java.awt.Dimension(85, 85));
        w.setPreferredSize(new java.awt.Dimension(85, 85));

        e.setText("E");
        e.setMaximumSize(new java.awt.Dimension(85, 85));
        e.setMinimumSize(new java.awt.Dimension(85, 85));
        e.setPreferredSize(new java.awt.Dimension(85, 85));

        d.setText("D");
        d.setMaximumSize(new java.awt.Dimension(85, 85));
        d.setMinimumSize(new java.awt.Dimension(85, 85));
        d.setPreferredSize(new java.awt.Dimension(85, 85));

        c.setText("C");
        c.setMaximumSize(new java.awt.Dimension(85, 85));
        c.setMinimumSize(new java.awt.Dimension(85, 85));
        c.setPreferredSize(new java.awt.Dimension(85, 85));

        r.setText("R");
        r.setMaximumSize(new java.awt.Dimension(85, 85));
        r.setMinimumSize(new java.awt.Dimension(85, 85));
        r.setPreferredSize(new java.awt.Dimension(85, 85));

        f.setText("F");
        f.setMaximumSize(new java.awt.Dimension(85, 85));
        f.setMinimumSize(new java.awt.Dimension(85, 85));
        f.setPreferredSize(new java.awt.Dimension(85, 85));

        v.setText("V");
        v.setMaximumSize(new java.awt.Dimension(85, 85));
        v.setMinimumSize(new java.awt.Dimension(85, 85));
        v.setPreferredSize(new java.awt.Dimension(85, 85));

        t.setText("T");
        t.setMaximumSize(new java.awt.Dimension(85, 85));
        t.setMinimumSize(new java.awt.Dimension(85, 85));
        t.setPreferredSize(new java.awt.Dimension(85, 85));

        g.setText("G");
        g.setMaximumSize(new java.awt.Dimension(85, 85));
        g.setMinimumSize(new java.awt.Dimension(85, 85));
        g.setPreferredSize(new java.awt.Dimension(85, 85));

        b.setText("B");
        b.setMaximumSize(new java.awt.Dimension(85, 85));
        b.setMinimumSize(new java.awt.Dimension(85, 85));
        b.setPreferredSize(new java.awt.Dimension(85, 85));

        y.setText("Y");
        y.setMaximumSize(new java.awt.Dimension(85, 85));
        y.setMinimumSize(new java.awt.Dimension(85, 85));
        y.setPreferredSize(new java.awt.Dimension(85, 85));

        h.setText("H");
        h.setMaximumSize(new java.awt.Dimension(85, 85));
        h.setMinimumSize(new java.awt.Dimension(85, 85));
        h.setPreferredSize(new java.awt.Dimension(85, 85));

        n.setText("N");
        n.setMaximumSize(new java.awt.Dimension(85, 85));
        n.setMinimumSize(new java.awt.Dimension(85, 85));
        n.setPreferredSize(new java.awt.Dimension(85, 85));

        u.setText("U");
        u.setMaximumSize(new java.awt.Dimension(85, 85));
        u.setMinimumSize(new java.awt.Dimension(85, 85));
        u.setPreferredSize(new java.awt.Dimension(85, 85));

        j.setText("J");
        j.setMaximumSize(new java.awt.Dimension(85, 85));
        j.setMinimumSize(new java.awt.Dimension(85, 85));
        j.setPreferredSize(new java.awt.Dimension(85, 85));

        m.setText("M");
        m.setMaximumSize(new java.awt.Dimension(85, 85));
        m.setMinimumSize(new java.awt.Dimension(85, 85));
        m.setPreferredSize(new java.awt.Dimension(85, 85));

        i.setText("I");
        i.setMaximumSize(new java.awt.Dimension(85, 85));
        i.setMinimumSize(new java.awt.Dimension(85, 85));
        i.setPreferredSize(new java.awt.Dimension(85, 85));

        k.setText("K");
        k.setMaximumSize(new java.awt.Dimension(85, 85));
        k.setMinimumSize(new java.awt.Dimension(85, 85));
        k.setPreferredSize(new java.awt.Dimension(85, 85));

        comma.setText(",");
        comma.setMaximumSize(new java.awt.Dimension(85, 85));
        comma.setMinimumSize(new java.awt.Dimension(85, 85));
        comma.setPreferredSize(new java.awt.Dimension(85, 85));

        o.setText("O");
        o.setMaximumSize(new java.awt.Dimension(85, 85));
        o.setMinimumSize(new java.awt.Dimension(85, 85));
        o.setPreferredSize(new java.awt.Dimension(85, 85));

        l.setText("L");
        l.setMaximumSize(new java.awt.Dimension(85, 85));
        l.setMinimumSize(new java.awt.Dimension(85, 85));
        l.setPreferredSize(new java.awt.Dimension(85, 85));

        stop.setText(".");
        stop.setMaximumSize(new java.awt.Dimension(85, 85));
        stop.setMinimumSize(new java.awt.Dimension(85, 85));
        stop.setPreferredSize(new java.awt.Dimension(85, 85));

        p.setText("P");
        p.setMaximumSize(new java.awt.Dimension(85, 85));
        p.setMinimumSize(new java.awt.Dimension(85, 85));
        p.setPreferredSize(new java.awt.Dimension(85, 85));

        backspace.setText("BKSPACE");
        backspace.setMargin(new java.awt.Insets(0, 0, 0, 0));
        backspace.setMaximumSize(new java.awt.Dimension(85, 85));
        backspace.setMinimumSize(new java.awt.Dimension(85, 85));
        backspace.setPreferredSize(new java.awt.Dimension(85, 85));

        enter.setText("ENTER");
        enter.setMaximumSize(new java.awt.Dimension(85, 85));
        enter.setMinimumSize(new java.awt.Dimension(85, 85));
        enter.setPreferredSize(new java.awt.Dimension(85, 85));

        rshift.setText("SHIFT");
        rshift.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rshift.setMaximumSize(new java.awt.Dimension(60, 60));
        rshift.setMinimumSize(new java.awt.Dimension(60, 60));
        rshift.setPreferredSize(new java.awt.Dimension(60, 60));

        lshift.setText("SHIFT");
        lshift.setMargin(new java.awt.Insets(0, 0, 0, 0));
        lshift.setMaximumSize(new java.awt.Dimension(85, 85));
        lshift.setMinimumSize(new java.awt.Dimension(85, 85));
        lshift.setPreferredSize(new java.awt.Dimension(85, 85));

        space.setMaximumSize(new java.awt.Dimension(85, 85));
        space.setMinimumSize(new java.awt.Dimension(85, 85));
        space.setPreferredSize(new java.awt.Dimension(85, 85));

        btnClose.setText("Close");
        btnClose.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnCloseActionPerformed(evt);
        });

        javax.swing.GroupLayout keyboardPanelLayout = new javax.swing.GroupLayout(keyboardPanel);
        keyboardPanel.setLayout(keyboardPanelLayout);
        keyboardPanelLayout.setHorizontalGroup(
                keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(keyboardPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(keyboardPanelLayout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(g, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(h, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(j, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(k, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(l, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(enter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(rshift, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, keyboardPanelLayout.createSequentialGroup()
                                                        .addComponent(q, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(w, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(i, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(o, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(backspace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, keyboardPanelLayout.createSequentialGroup()
                                                        .addComponent(lshift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(keyboardPanelLayout.createSequentialGroup()
                                                                        .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(comma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(space, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        keyboardPanelLayout.setVerticalGroup(
                keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, keyboardPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(q, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(o, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(i, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(u, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(r, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(e, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(w, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(backspace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(l, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(enter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(k, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(j, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(h, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(g, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lshift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(rshift, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(comma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(v, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(keyboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(space, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(103, 103, 103))
        );

        if (parent instanceof JFrame) {
            JFrame frameParent = (JFrame) parent;
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frameParent.getContentPane());
            frameParent.getContentPane().setLayout(layout);

            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 1024, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(keyboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 323, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(keyboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE)))
            );

            frameParent.pack();
        }
    }// </editor-fold>                        

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {

    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton a;
    private javax.swing.JButton b;
    private javax.swing.JButton backspace;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton c;
    private javax.swing.JButton comma;
    private javax.swing.JButton d;
    private javax.swing.JButton e;
    private javax.swing.JButton enter;
    private javax.swing.JButton f;
    private javax.swing.JButton g;
    private javax.swing.JButton h;
    private javax.swing.JButton i;
    private javax.swing.JButton j;
    private javax.swing.JButton k;
    private javax.swing.JPanel keyboardPanel;
    private javax.swing.JButton l;
    private javax.swing.JToggleButton lshift;
    private javax.swing.JButton m;
    private javax.swing.JButton n;
    private javax.swing.JButton o;
    private javax.swing.JButton p;
    private javax.swing.JButton q;
    private javax.swing.JButton r;
    private javax.swing.JToggleButton rshift;
    private javax.swing.JButton s;
    private javax.swing.JButton space;
    private javax.swing.JButton stop;
    private javax.swing.JButton t;
    private javax.swing.JButton u;
    private javax.swing.JButton v;
    private javax.swing.JButton w;
    private javax.swing.JButton x;
    private javax.swing.JButton y;
    private javax.swing.JButton z;
    // End of variables declaration  
}
