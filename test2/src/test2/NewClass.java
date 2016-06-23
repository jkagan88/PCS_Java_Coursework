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
public class NewClass
{
    //Arguments argument = new Arguments();
    
    public static void add(Arguments argument)
    {
        argument.setAnswer(argument.getLeft() + argument.getRight());
    }
    
    public static void subtract(Arguments argument)
    {
        argument.setAnswer(argument.getLeft() - argument.getRight());
    }
     
      public static void divide(Arguments argument)
    {
        argument.setAnswer(argument.getLeft() / argument.getRight());
    }
      
    public static void multiply(Arguments argument)
    {
        argument.setAnswer(argument.getLeft() * argument.getRight());
    }
}
