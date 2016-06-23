/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author YYKF
 */
public class Checking extends Account
{
    double minumum = 100.0;
    double fee = 10.0;
    int withdrawalsAvailable = 2;
    
    
    @Override
    public void doEndOfMonth()
    {
        if(getBalance() < minumum)
        {
            super.balanceChange(-fee, "Monthly Fee"); 
        }
        withdrawalsAvailable = 2;
        super.doEndOfMonth();
    }

    @Override
    public void balanceChange(double draw)
    {
        super.balanceChange(draw);
        if (draw < 0)
        {     
            if(withdrawalsAvailable <= 0)
            {
                super.balanceChange(-fee, "Withdrawal Fee");
            }
            withdrawalsAvailable--;
        }
    }
}
