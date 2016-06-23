/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweaper;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author YYKF
 */
public class MineSquare extends JLabel
{
    JLabel jl = new JLabel();
    private boolean bomb;
    private boolean called;
    private int touching;
    private boolean pressable = true;
    private int cycle = 0;
    
    MineSquare()
    {
        setFont(jl.getFont().deriveFont(60.0F));       
        setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon buttonIcon = new ImageIcon("resources/images/start.png");
        setIcon(buttonIcon);
        //jl.setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        setOpaque(true);

    }

    /**
     * @return the bomb
     */
    public boolean isBomb() {
        return bomb;
    }

    /**
     * @param bomb the bomb to set
     */
    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    /**
     * @return the touching
     */
    public int getTouching() {
        return touching;
    }

    /**
     * @param touching the touching to set
     */
    public void setTouching(int touching) {
        this.touching = touching;
    }

    /**
     * @return the called
     */
    public boolean isCalled() {
        return called;
    }

    /**
     * @param called the called to set
     */
    public void setCalled(boolean called) {
        this.called = called;
    }

    /**
     * @return the pressable
     */
    public boolean isPressable() {
        return pressable;
    }

    /**
     * @param pressable the pressable to set
     */
    public void setPressable(boolean pressable) {
        this.pressable = pressable;
    }

    /**
     * @return the cycle
     */
    public int getCycle() {
        return cycle;
    }

    /**
     * @param cycle the cycle to set
     */
    public void setCycle(int cycle) {
        this.cycle = cycle;
    }
}
