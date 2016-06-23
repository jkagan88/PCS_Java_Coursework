/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework19;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author YYKF
 */
public class JLabelColored
{
    int timesClicked = 0;
    JLabel jLabel = new JLabel();
    
    private static Color[] colors = {Color.BLUE, Color.RED, Color.YELLOW,Color.MAGENTA,Color.CYAN, Color.GREEN, Color.white, Color.ORANGE, Color.BLACK};
    
    public JLabelColored()
    {
        Border b = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3);
        jLabel.setBorder(b);
        jLabel.setOpaque(true);
        jLabel.setBackground(Color.BLACK);
        
        jLabel.addMouseListener(new MouseAdapter() 
                
        {

            @Override
            public void mousePressed(MouseEvent e) 
            {       
                
                
                
                jLabel.setBackground(colors[timesClicked]);
                timesClicked++;
                if(timesClicked>=colors.length)
                    timesClicked = 0;
//                switch (timesClicked)
//                {   
//                    case 0: 
//                        jLabel.setBackground(Color.RED);
//                        timesClicked++;
//                        break;
//                    case 1: jLabel.setBackground(Color.ORANGE);
//                    timesClicked++;
//                        break;
//                    case 2: jLabel.setBackground(Color.BLUE);
//                    timesClicked++;
//                        break;
//                    case 3: jLabel.setBackground(Color.GREEN);
//                    timesClicked++;
//                        break;
//                    case 4: jLabel.setBackground(Color.CYAN);
//                    timesClicked++;
//                        break;
//                    case 5: jLabel.setBackground(Color.BLACK);
//                    timesClicked = 0;
//                        break;
//                }
            }
        });
    }
        
    
}
