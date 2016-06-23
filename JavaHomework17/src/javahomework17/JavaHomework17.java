/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework17;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
/**
 *
 * @author YYKF
 */
public class JavaHomework17
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        JLabel title = new JLabel("Checking Account 2332445", SwingConstants.CENTER);
        frame.add(title, BorderLayout.PAGE_START);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Withdraw and deposit TextFields and center panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        Border b = BorderFactory.createLineBorder(Color.yellow, 3);
        mainPanel.setBorder(b);
        frame.add(mainPanel, BorderLayout.CENTER);
        JLabel transactionLabel = new JLabel("Transaction");
        JTextField transactionText = new JTextField(15);
        JPanel withdrawPanel = new JPanel(new FlowLayout());
        withdrawPanel.add(transactionLabel);
        withdrawPanel.add(transactionText);
        mainPanel.add(withdrawPanel, BorderLayout.PAGE_START);
        
        //Text area
        JTextArea endList = new JTextArea(10, 10);
        mainPanel.add(endList, BorderLayout.PAGE_END);
        
        //Add and end of month buttons
        JPanel bottomPanel = new JPanel(new FlowLayout());
        JButton depositButton = new JButton("Deposit");
        JButton endOfMonth = new JButton("End Of Month");
        JButton withdrawButton = new JButton("Withdraw");
        depositButton.setPreferredSize(endOfMonth.getPreferredSize());
        withdrawButton.setPreferredSize(endOfMonth.getPreferredSize());
        bottomPanel.add(depositButton);
        bottomPanel.add(Box.createRigidArea(new Dimension(50,0)));
        bottomPanel.add(withdrawButton);
        bottomPanel.add(Box.createRigidArea(new Dimension(50,0)));
        bottomPanel.add(endOfMonth);
        frame.add(bottomPanel, BorderLayout.PAGE_END);
        
        frame.setSize(900, 550);
        frame.setVisible(true);
    }
    
}
