/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclass2;

/**
 *
 * @author YYKF
 */
public class JavaClass2
  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
      {
        int newint = 10;
        newint = newint * 10;
        byte d = 5;
        int b = d;
       
        byte i = (byte)b;
        System.out.println("5 + 5 = " + (5+5));
        System.out.println(5 + 5 + "=" + newint);
        System.out.println(b + i );
        
        byte b1 =31;
        byte b2 =21;
        byte b3 = (byte)(b1+b2);
        
        float first = (float)5.5;
        float second = first;
        float third = 55.55F;
        char c = 'c';
        char cc = '\u05E0';
        System.out.println(second + ("  ") + b3 + cc);
        
        char upper = 'D';
        int diff = 'a' - 'A';
        char lower = (char)(upper - diff);
        System.out.println(lower);
        
        int ig = 5%2;
        
       
      }
    
  }
