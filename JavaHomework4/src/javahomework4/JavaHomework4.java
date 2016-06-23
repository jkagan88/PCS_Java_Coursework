/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework4;

import java.util.Scanner;

/**
 *
 * @author YYKF
 */
public class JavaHomework4
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //17. prints out all even numbers less than 1000
        for (int even = 2; even < 1000; even += 2)
        {
            System.out.print(" " + even);
        }

        System.out.println();
        for (int rannumber = 65; rannumber >= 0; rannumber--)
        {
            System.out.print(" " + rannumber);
        }

        //18. Prints out a number if the number is more than zero, and subtracts 
        //until it reaches zero
        System.out.println();
        int rannumber2 = 65;
        do
        {
            System.out.print(" " + rannumber2--); //+ rannumber2);

        } while (rannumber2 >= 0);

        //Number guessing game. After game is won prints out number of guesses.
        //Gives you a choice to start a new game or to exit.
        System.out.println("");
        int theNumber = (int) (Math.random() * 100) + 1;
        System.out.println("Guess the number between 1-100");
        Scanner userInputThing = new Scanner(System.in);
        int numguesses = 0;

        boolean gameOver = false;
        while (gameOver == false)
        {
            int guess = userInputThing.nextInt();
            if (guess > theNumber)
            {
                System.out.println("Your answer was too high");
                numguesses++;
            } else if (guess < theNumber)
            {
                System.out.println("Your answer was too low");
                numguesses++;
            } else
            {
                numguesses++;
                System.out.println("You won!! The answer is " + theNumber + "\nYou have guessed the answer in "
                        + numguesses + " guesses");
                      //gameOver = true;

                //code to start new game or to exit
                Scanner endOrNot = new Scanner(System.in);
                System.out.println("Do you want to play again? Enter 0 to quit, 1 to play again");
                int choice = endOrNot.nextInt();
                if (choice <= 0)
                {
                    gameOver = true;
                } else if (choice >= 1)
                {
                    System.out.println("You have chosen to start a new game");
                    theNumber = (int) (Math.random() * 100) + 1;
                }

            }
        }

        //coin flipping program
        int heads = 0;
        int tails = 0;
        int theNumber2 = (int) (Math.random() * 2);  //*100)+1;
        System.out.println("\nFlip a coin 100 times");
        int flip = 0;
        while (flip < 100)
        {
            flip++;
            theNumber2 = (int) (Math.random() * 2);
            if (theNumber2 == 1)
            {
                ++heads;
            } else if (theNumber2 == 0)
            {
                ++tails;
            }
        }
        System.out.println("The coin landed on heads " + heads + " times" + "\nThe coin landed on tails " + tails + " times.");

        //Program for printing out pattern
        for (int lines = 0; lines < 5; lines++)
        {

            for (int astrx = 0; astrx <= lines; astrx++)
            {
                System.out.print("*");
            }
            System.out.println("");

        }
    }

}
