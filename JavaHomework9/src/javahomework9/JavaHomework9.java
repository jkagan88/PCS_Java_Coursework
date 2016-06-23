/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework9;

/**
 *
 * @author YYKF
 */
public class JavaHomework9
{

    public static int [] total = new int [13];
    
    public static int rollDie()
    {
        int number = 0;                                                                                                                                                                                                             
        number = (int) (Math.random()* 6 + 1);
        return number;
    }
    
    public static void rollDice()
    {
        int i = rollDie() + rollDie();
        total[i]++;
    }
    
    public static void main(String[] args) 
    {
        int x = 2;
        for (int i = 0; i < 36000; i++)
        {
            rollDice();
        }
        for (int i = 2; i < total.length; i++)
        { 
            System.out.println("You rolled " + x + " " + total[i] + " times");
            x++;
        }
        
    }
    
 
}
