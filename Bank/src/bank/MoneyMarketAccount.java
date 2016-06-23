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
public class MoneyMarketAccount extends InterestBearingAccount
{
    double fee = 2;
    double checksAvailable = 2;
    
    @Override
    public void doEndOfMonth()
    {
        super.doEndOfMonth(0.002);
        fee = 2;
    }
    
    public void withdraw(double draw)
    {
        super.balanceChange(-draw);
        if (checksAvailable <= 0)
        {
            super.balanceChange(-fee, "Check Fee");
        }
        --checksAvailable;
    }
}
