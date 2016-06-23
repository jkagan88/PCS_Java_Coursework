/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclass4;

import java.util.Scanner;

/**
 *
 * @author YYKF
 */
public class JavaClass4
  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
      {
        int year = 2104;
        if(year % 4 == 0 && (year%100 != 0 || year%400 == 0))
          {
            System.out.println("It is a leap year");
          }
        else
          {
            System.out.println("It is not a leap year");
          }
        
        int counter = 0;
        while(counter <=10)
          {
            System.out.println("the counter is at " +counter++);
          }
        
        do
          {
            System.out.println("the counter is at " +counter);
          }  
        while(counter <10);
        
        
        
        
        
        
//        int theNumber = (int)(Math.random()*100)+1;
//        System.out.println("Guess the number between 1-100");
//        Scanner userInputThing = new Scanner(System.in);
//        
//        boolean gameOver = false;
//        while(gameOver == false)
//          {
//            int guess = userInputThing.nextInt();
//            if (guess > theNumber)
//                    {
//                      System.out.println("Your answer was too high");
//                    }
//            else if (guess < theNumber)
//                    {
//                      System.out.println("Your answer was too low");
//                    }
//            else 
//                    {
//                      
//                      System.out.println("You won!! The answer is " + theNumber);
//                      gameOver = true;
//                    }
//          }
        
        
        
        
        int i = 0;
        while(i<10)
          {
            System.out.println("i is " +i);
            i++;
          }
        
        
        for(int x = 1; x<10; x++)
          {
            //System.out.println("x is " +x);
            if(x==3)
              {
                continue;
              }
            System.out.println(x);
            if(x==6)
              {
                break;
              }
          }
        
        
        
        
        for(int yy = 1; yy<=10; yy++)
          {
            for(int j = 1; j<=10; j++)
              {
                System.out.println("yy is " + yy + " and j is " + j);
                //break;
              }
          }
        
        
        for(int kf = 1; kf<=10; kf++)
          {
            for(int fk = 1; fk<=10; fk++)
              {
                System.out.println(kf + " times " + fk + " = " + (kf*fk));
                //break;
              }
          }
        
        
        int day = 5;
        switch(day)
          {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednsday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
          }
      }
    
  }
