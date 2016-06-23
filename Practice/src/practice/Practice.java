/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author YYKF
 */
public class Practice
{


    public static int sum(int [] args)
    {
        int total = 0;
        for (int number : args)
        {
            total += number;
        }
        return total;
    }
    
     public static int sumVarArgs(int... args)
    {
        int total = 0;
        for(int i = 0; i <args.length; i++)
        //for (int number : args)
        {
            //total += number;
            total += args[i];
        }
        return total;
    }
    
    public static void main(String[] args)
    {
        String [] setOfNames = {"Jack","Phil","john"};
        
        //old way
        for (int i = 0; i < setOfNames.length; i++)
        {
            String name = setOfNames[i];
            //setOfNames[i] = "some other name";
            System.out.println(setOfNames[i]);
            System.out.println(name);
        }
        
        for(String name : setOfNames)
        {
            System.out.println(name);
        }
        
        //call sum wth an array of numbers
        int [] numbers = {6, 9, 7};
        int total = sum(numbers);
        
        //call a varargs method
        total = sumVarArgs(6,9,2);
        System.out.println(total);
        float f = 6.8f;

        //seeing String .format in action
        String hi = "hi there";
        String printedString = "First this " + total +" then this " + f + " and then this " + hi; 
        System.out.println(printedString);
        String printedString2 = String.format("First this %d then this %f and then this %s", total, f, hi); 
        System.out.println(printedString2);
    }
    
}
