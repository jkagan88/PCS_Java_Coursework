/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/**
 *
 * @author YYKF
 */
public class Party
{
    
    public void setTime(Time time)
    {
        if (time.getHour() == 11 && time.getMinute() == 0 && time.getSecond() == 0)
        {
            System.out.println("Time to party!");
        }
        else
        {
            System.out.println(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
        }
    }


    
}
