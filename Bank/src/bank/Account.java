/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author YYKF
 */
public abstract class Account
{
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    int transactionNumber = -1;
    double balance;
    JTextArea endList = new JTextArea(10,10);

    
    public void balanceChange(double deposit)
    {
        String transaction;
        if (deposit >= 0)
            transaction = "Deposit ";
        else
            transaction = "Withdrawal ";
        
        this.balanceChange(deposit, transaction);
    }
    
    public void balanceChange(double deposit, String transactionType)
    {
        balance+=deposit;
        createTransaction("12/12/2016", transactionType, deposit);
        
        String parsedTransaction = Double.toString(deposit);
        String parsedBalance = Double.toString(balance);
        endList.append(transactionType + parsedTransaction + "    AccountBalance: " + parsedBalance + "\n");
    }
    
    public void createTransaction(String a, String b, double c)
    {
        Transaction transaction = new Transaction(a, b, c);
        ++transactionNumber;
        transactions.add(transaction);
    }

    public double getBalance()
    {
        return balance;
    }
    
    
    public void doEndOfMonth()
    {
        endList.append("the balance is: " + balance + "\n");
        for (int i = 0; i<transactions.size(); i++)
        {
            if (transactions.get(i) == null)
            {
                break;
            }
            endList.append(transactions.get(i).print());
        }
    }
}
