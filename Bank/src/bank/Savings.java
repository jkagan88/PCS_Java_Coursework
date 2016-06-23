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
public class Savings extends InterestBearingAccount


{
    @Override
    public void doEndOfMonth()
    {
        super.doEndOfMonth(0.006);
    }
}
