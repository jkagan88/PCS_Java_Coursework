/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweaper;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author YYKF
 */
public class MineSweaperGUI
{
    private static int length = 13;
    private static int width = 13;
    int buttonSize = 80;
    MineSquare [][] mineBoard = new MineSquare [getLength()][getWidth()];
    Logic logic = new Logic();
    public static JLabel topLabel = new JLabel("MineSweaper" , SwingConstants.CENTER);
    
    public void setTimer(final String message)
    {
        if(logic.isFirstClick())
        {
            SwingUtilities.invokeLater(new Runnable(){

                @Override
                public void run()
                {
                    while (logic.isGameOver() == false)
                    {
                        topLabel.setText(Integer.toString(logic.getCounter()));
                    }
                }
            });
        }
    }
    
    public MineSweaperGUI()
    {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel(new GridLayout(getLength(), getWidth()));
        frame.add(mainPanel, BorderLayout.CENTER);
        
        topLabel.setFont(topLabel.getFont().deriveFont(40.0F));
        frame.add(topLabel, BorderLayout.PAGE_START);
        
        JPanel bottomPanel = new JPanel(new FlowLayout());
        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    
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
        
        //Setup the panel with MineSquares
        for (int i = 0; i<length; i++)
        {
            for (int j = 0; j<width; j++)
            {
                mineBoard[i][j] = new MineSquare();
                mainPanel.add(mineBoard[i][j]);
                
                mineBoard[i][j].addMouseListener(new MouseAdapterImpl(i, j));
                
            }
        }

        
        frame.setSize(length * buttonSize, width * buttonSize);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //logic.setBombs(mineBoard);
    
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    private class MouseAdapterImpl extends MouseAdapter
    {

        private final int i;
        private final int j;

        public MouseAdapterImpl(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void mouseClicked(MouseEvent e)
        { 
            
            if (e.getButton() == 1 && mineBoard[i][j].isPressable())
            {   
                logic.timer();
                
                mineBoard[i][j].setCalled(true);
                logic.setBombs(mineBoard);
                if (mineBoard[i][j].isBomb())
                {
                    mineBoard[i][j].setIcon(new ImageIcon("resources/images/explosion.png"));
                    logic.gameLost(mineBoard);
                }
                else
                {    
                    if (mineBoard[i][j].getTouching() != 0)
                    {
                        mineBoard[i][j].setIcon(null);
                        mineBoard[i][j].setText(Integer.toString(mineBoard[i][j].getTouching()));

                    }
                    else 
                    {
                       mineBoard[i][j].setIcon(new ImageIcon("resources/images/back.png")); 
                       logic.bordering(i, j, mineBoard); 
                    }

                }
            }
            
            //Code for placing flags
            else if (e.getButton() == 3 && mineBoard[i][j].isCalled() == false)
            {
                
                if (mineBoard[i][j].getCycle() == 0)
                {
                    mineBoard[i][j].setIcon(new ImageIcon("resources/images/flag.png"));
                    mineBoard[i][j].setPressable(false);
                    mineBoard[i][j].setCycle(1);
                }
                else if (mineBoard[i][j].getCycle() == 1)
                {
                    mineBoard[i][j].setPressable(true);
                    mineBoard[i][j].setIcon(new ImageIcon("resources/images/question.png"));
                    mineBoard[i][j].setCycle(2);
                }
                else if (mineBoard[i][j].getCycle() == 2)
                {
                    mineBoard[i][j].setIcon(new ImageIcon("resources/images/start.png"));
                    mineBoard[i][j].setCycle(0);
                }
            }
            logic.gameWon(mineBoard[i][j], mineBoard);
        }
    }
}
