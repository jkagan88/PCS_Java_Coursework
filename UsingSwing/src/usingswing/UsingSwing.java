/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingswing;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author YYKF
 */
public class UsingSwing
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
//        frame.setLayout(new FlowLayout());
        frame.setLayout(new GridLayout(10,10));
//        frame.setLayout(new BorderLayout());
        for (int i = 0; i < 100; i++)
        {
            JLabel label = new JLabel("" + i);
            frame.add(label);
        }
        
        frame.setSize(1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
}
