/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author YYKF
 */
public class Homework_2
  {
    public static void main(String[] args)
      {
        System.out.print("Joseph Kahan-Frankl\n634 6th Street"
                + "\nLakewood, NJ 08701\n4162563902");
        System.out.print("\n\n\n  /\\\n /  \\\n------\n[ * * ]\n   \"\n\n   ^");
        
        
        int int1 = 2+2;
        int int2 = 3*3;
        int int3 = 10/2;
        System.out.print("\n\n2 + 2 = " + (2+2) + "\n3 * 3 = " + (3*3)
        + "\n10 / 2 = " + (10/2));
        
        short s = 5;
        byte b = 6;
        int i = 613;
        int bigint = s + b + i;
        System.out.print("\n" + bigint);
        
        short s2 = 5;
        byte b2 = 6;
        int i2 = 613;
        byte bigint2 = (byte)(s + b + i);
        //answer is incorect because 624 cant fit in a byte
        System.out.print("\n" + bigint2);
        
        int oddnumber = 55;
        //float halfodd = (float)oddnumber /2;
        double halfodd = oddnumber /2.0;
        System.out.print("\n55/2 = " + (halfodd));
        System.out.print("\n55/2 = " + "" + oddnumber / 2 + "r" + oddnumber % 2);
        
        float test1 = 83.4F;
        float test2 = 91.4F;
        float test3 = 97.5F;
        float average = (float)((test1 + test2 + test3) / 3);
        int varaverage = (int)average;
        System.out.println("\n" + varaverage);
        
        char lower = 'v';
        int diff = 'a' - 'A';
        char upper = (char)(lower - diff);
        System.out.println(upper);
        
      }
  }

