/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework20;

import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author YYKF
 */
public class XO_GUI
{
    
    int length = 3;
    int width = 3;
    int buttonSize = 500;
    private JLabel [][] xando = new JLabel [3][3];
    XO_back back = new XO_back();
        
    public JLabel jl()
    {   
        JLabel jl = new JLabel();
        jl.setSize(width, length);
        jl.setFont(jl.getFont().deriveFont(120.0F));
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        Border b = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3);
        jl.setBorder(b);
        jl.setOpaque(true);        
        jl.addMouseListener(new MouseAdapter()
                
        {

            @Override
            public void mouseClicked(MouseEvent e) 
            {       
                    back.addXorO(jl);
                    back.checkIfOver(xando);
                    back.AI(xando);
                    back.checkIfOver(xando);
                       
            }
        });
        return jl;
    }
    
    public XO_GUI()
    {
        
        
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel(new GridLayout(length,width));
        frame.add(mainPanel, BorderLayout.CENTER);
        
        JLabel topLabel = new JLabel("TickTackToe", SwingConstants.CENTER);
        frame.add(topLabel, BorderLayout.PAGE_START);
        
        JPanel bottomPanel = new JPanel(new FlowLayout());
        
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    for (int i = 0; i<3; i++)
                    {
                        for (int j = 0; j<3; j++)
                        {
                            xando[i][j].setText("");
                        }
                    }
                    back.setXorO(0);
                }
        
        });
        
        JButton exitButton = new JButton("Exit");
        
        exitButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    frame.dispose();
                }
        
        });
        
        exitButton.setPreferredSize(restartButton.getPreferredSize());
        bottomPanel.add(restartButton);
        bottomPanel.add(Box.createRigidArea(new Dimension(50,0)));
        bottomPanel.add(exitButton);
        frame.add(bottomPanel, BorderLayout.PAGE_END);
        
        
        for (int i = 0; i<3; i++)
        {
            for (int j = 0; j<3; j++)
            {
                xando[i][j] = jl();
            }
        }
        
        for (int i = 0; i<3; i++)
        {
            for (int j = 0; j<3; j++)
            {
                mainPanel.add(xando[i][j]);
            }
        }

        
        frame.setSize(length * buttonSize, width * buttonSize);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        
    }

    /**
     * @return the xando
     */
    public JLabel getXando(int i, int j) {
        return xando[i][j];
    }

    /**
     * @param xando the xando to set
     */
    public void setXando(JLabel[][] xando) {
        this.xando = xando;
    }
}
