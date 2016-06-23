/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import static test2.printer.timesTwo;

/**
 *
 * @author YYKF
 */
public class Test2
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
                Arguments argument = new Arguments(10, 2); 
                NewClass.subtract(argument);
                Arguments.show(argument);
                NewClass.add(argument);
                Arguments.show(argument);
                NewClass.divide(argument);
                Arguments.show(argument);
                NewClass.multiply(argument);
                Arguments.show(argument);
                
                Party party = new Party();
                Time time1 = new Time(11,0,0);
                Time time2 = new Time(1,1,1);
                party.setTime(time1);
                party.setTime(time2);
                time2.setHour(11);
                time2.setMinute(0);
                time2.setSecond(0);
                party.setTime(time2);
                
    }


    
}
