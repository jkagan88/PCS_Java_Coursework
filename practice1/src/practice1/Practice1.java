/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice1;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author YYKF
 */
public class Practice1
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        for (int i= 2; i<1000; i+=2)
        {
            if (i % 50== 0)
            {
                System.out.print("\n");
            }
            System.out.print(i + " ");
        }   
        System.out.print("\n");
     
        
        
        int random = (int) (Math.random() * 100);
        do
        {
            System.out.println(random--);
        } while (random > -1);
        
        String astrix = "*";
        for (int u=0; u<10; u++)
        {
            System.out.println(astrix);
            astrix += "*" ;
        }
        
        
        
        int toGuess = (int) (Math.random() * 10);
        int guess = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess the number");
        boolean gameOver = false;
        int counter = 0;
        
        while (!gameOver)
        {
            guess = scanner.nextInt();
            ++counter;
            if (guess < toGuess)
            {
                System.out.println("Youre guess was too low \nGuess again");
            }
            else if (guess > toGuess)
            {
                System.out.println("Youre guess was too high \nGuess again");
            }
            else
            {
                System.out.println("You have won!! The number is " + toGuess);
                if (counter == 1)
                    System.out.println("It took one guess");
                else
                    System.out.println("It took " + counter +  " guesses");
                System.out.println("Do you want to play again?\nIf yes press 1 if not press 0");
                guess = scanner.nextInt();
                if (guess == 0)
                {
                    gameOver = true;
                }
                else
                {
                    counter = 0;
                    toGuess = (int) (Math.random() * 10);
                    System.out.println("You have chosen to start a new game\nGuess the number");
                }
            }           
        }
        
        int heads = 0;
        int tails = 0;
        for (int ii=0; ii<1000; ii++)
        {
            int roll = (int)(Math.random() * 2);
            if (roll == 1)
            {
                ++heads;
            }
            else
                ++tails;
        }
        System.out.println("heads: " + heads + " tails: " + tails);
    }    
}
