/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.davidg95.davidscodelibrary;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author David
 */
public class BarChart extends JComponent{
    @Override
    public void paintComponent(Graphics g){
        //Draw the bars
        g.fillRect(0, 10, 200, 10);
        g.fillRect(0, 30, 300, 10);
        g.fillRect(0, 50, 100, 10);
        
        //Draw the arrow
        g.drawLine(350, 35, 305, 35);
        g.drawLine(305, 35, 310, 30);
        g.drawLine(305, 35, 310, 40);
        
        //Draw the highlight and the text
        g.setColor(Color.YELLOW);
        g.fillOval(350, 25, 35, 20);
        g.setColor(Color.BLACK);
        g.drawString("Best", 355, 40);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        
        frame.setSize(400, 200);
        frame.setTitle("A Bar Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JComponent comp = new BarChart();
        
        frame.add(comp);
        
        frame.setVisible(true);
    }
}
