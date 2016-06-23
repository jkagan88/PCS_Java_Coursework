/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework19;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author YYKF
 */
public class LiteBrite
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int length = 17;
        int width = 17;
        int buttonSize = 100;
        
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(length,width));
        
        for (int i = 0; i<length*width; i++)
        {
            frame.add(new JLabelColored().jLabel);
        }
        frame.setResizable(false);
        frame.setSize(length * buttonSize, width * buttonSize);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
