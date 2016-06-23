/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclass3;

/**
 *
 * @author YYKF
 */
public class Javaclass3
  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
      {
        int x = 5;
        x = x + 5;
        x += 5;
        x++;
        System.out.println(x);
        
        int a = 5;
        int b = ++a;
        b++;
        System.out.println(b);
        
        boolean isNight = true;
        if(!isNight == false)
          {
            System.out.println("it is day");
          }
        else
          {
            System.out.println("It is night");
          }
        
      }
    
  }
