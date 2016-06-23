/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework3;

/**
 *
 * @author YYKF
 */
public class JavaHomework3
  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
      {
        //double x using 4 characters
        int x = 10;
        if (x == 10) 
                {
                  x*=2;
                  System.out.println(x);
                }
        
        
        //decrements but stii writes x as 10
        x  = 10;
        System.out.println(x--);
        x = --x;
        System.out.println(x);
        
        //prints out test scores
        int score = 64;
        if (score > 89)
          {
            System.out.println("You got an A");
          }
        else if (score > 79 && score < 90)
          {
            System.out.println("You got a B");
          }
        else if (score > 69 && score < 80)
          {
            System.out.println("You got a C");
          }
        else if (score > 64 && score < 70)
          {
            System.out.println("You got a D");
          }
        else
          {
            System.out.println("You got a F");
          }
        
        
        //Converts month number to month name
        int cmonth = 6;
        
        if (cmonth == 1)
          {
            System.out.println("January");
          }
        else if (cmonth == 2)
          {
            System.out.println("February");
          }
        else if (cmonth == 3)
          {
            System.out.println("March");
          }
        else if (cmonth == 4)
          {
            System.out.println("April");
          }
        else if (cmonth == 5)
          {
            System.out.println("May");
          }
        else if (cmonth == 6)
          {
            System.out.println("June");
          }
        else if (cmonth == 7)
          {
            System.out.println("July");
          }
        else if (cmonth == 8)
          {
            System.out.println("August");
          }
        else if (cmonth == 9)
          {
            System.out.println("September");
          }
        else if (cmonth == 10)
          {
            System.out.println("October");
          }
        else if (cmonth == 11)
          {
            System.out.println("November");
          }
        else if (cmonth == 12)
          {
            System.out.println("December");
          }
        else
          {
            System.out.println("You have entered an invalid number");
          }
        
        
                //Prints out integer value as a word
        int lessnten = 9;
        
        if (lessnten == 1)
          {
            System.out.println("One");
          }
        else if (lessnten == 2)
          {
            System.out.println("Two");
          }
        else if (lessnten == 3)
          {
            System.out.println("Three");
          }
        else if (lessnten == 4)
          {
            System.out.println("Four");
          }
        else if (lessnten == 5)
          {
            System.out.println("Five");
          }
        else if (lessnten == 6)
          {
            System.out.println("Six");
          }
        else if (lessnten == 7)
          {
            System.out.println("Seven");
          }
        else if (lessnten == 8)
          {
            System.out.println("Eight");
          }
        else if (lessnten == 9)
          {
            System.out.println("Nine");
          }
        else
          {
            System.out.println("You have entered an invalid number");
          }
      }
    
  }
