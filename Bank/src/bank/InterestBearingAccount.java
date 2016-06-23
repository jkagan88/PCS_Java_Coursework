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
public  abstract class InterestBearingAccount extends Account
{
    public void doEndOfMonth(double intrestRate)
    {
        double intrest = getBalance()*intrestRate;
        super.balanceChange(intrest, "Intrest");
        super.doEndOfMonth();
    }
}
