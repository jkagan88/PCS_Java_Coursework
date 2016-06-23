/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author YYKF
 */
public class BankGUI
{
    
    static public Account account;
    JButton undoButton = new JButton("Undo");
    JButton redoButton = new JButton("Redo");
        
    
    public BankGUI()
    {
        this.account = new Checking();
                
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        JLabel title = new JLabel(this.account.getClass().getSimpleName(), SwingConstants.CENTER);
        frame.add(title, BorderLayout.PAGE_START);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Withdraw and balanceChange TextFields and center panel
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
        JScrollPane scroll = new JScrollPane(account.endList);
        mainPanel.add(scroll, BorderLayout.PAGE_END);
        
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
        bottomPanel.add(Box.createRigidArea(new Dimension(200,0)));
        bottomPanel.add(undoButton);
        bottomPanel.add(redoButton);
        frame.add(bottomPanel, BorderLayout.PAGE_END);
        validateStacks();
        
        depositButton.addActionListener(new ActionListener(){       
        public void actionPerformed(ActionEvent e)
        {
            double parsedDouble = Double.parseDouble(transactionText.getText());
            CreateBankTransactionCommand cbt = new CreateBankTransactionCommand(parsedDouble, account);
            UndoRedoManager.getInstance().execute(cbt); 
            validateStacks();  
        }    
        });
        
        withdrawButton.addActionListener(new ActionListener(){       
        public void actionPerformed(ActionEvent e)
        {
            double parsedDouble = Double.parseDouble(transactionText.getText());
            CreateBankTransactionCommand cbt = new CreateBankTransactionCommand(-parsedDouble, account);
            UndoRedoManager.getInstance().execute(cbt);
            validateStacks();        
        }    
        });
        
        endOfMonth.addActionListener(new ActionListener(){       
        public void actionPerformed(ActionEvent e)
        {
            account.doEndOfMonth();
            validateStacks();
        }    
        });
        
        undoButton.addActionListener(new ActionListener(){       
        public void actionPerformed(ActionEvent e)
        {
            UndoRedoManager.getInstance().undo();
            validateStacks();
        }    
        });
        
        redoButton.addActionListener(new ActionListener(){       
        public void actionPerformed(ActionEvent e)
        {
            UndoRedoManager.getInstance().redo();
            validateStacks();  
        }    
        });
        
        frame.setSize(900, 550);
        frame.setVisible(true);
    }
    
    public void validateStacks()
    {
        redoButton.setEnabled(UndoRedoManager.getInstance().redoEmpty() != true);
        undoButton.setEnabled(UndoRedoManager.getInstance().undoEmpty() != true); 
    }
}
