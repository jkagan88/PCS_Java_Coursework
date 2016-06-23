/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclass8;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author YYKF
 */
public class JavaClass8
{

    public static int[][] board = new int[10][10];
    public static int foo = 0;

    public static void populateBoard() 
    {

        while (foo != 63)
        {

            for (int arylst = 0; arylst < board.length; arylst++)
            {
                for (int i = 0; i < board[arylst].length; i++)
                {
                    board[arylst][i] = 0;

                }
            }

            foo = 0;
            int[] boats =
            {
                2, 3, 3, 4, 5
            };

            for (int i = 0; i < boats.length; i++)
            {

                int maxRow = 10;
                int maxColumn = 10;
                int oriantation = (int) (Math.random() * 2);
                if (oriantation == 0)
                {
                    maxRow -= boats[i] - 1;

                } else
                {
                    maxColumn -= boats[i] - 1;

                }
                int row = (int) (Math.random() * maxRow);
                int column = (int) (Math.random() * maxColumn);
                for (int j = 0; j < boats[i]; j++)
                {
                    board[row][column] = boats[i];
                    if (oriantation == 1)
                    {
                        column++;
                    } 
                    else
                    {
                        row++;
                    }
                }
            }

            for (int arylst = 0; arylst < board.length; arylst++)
            {
                for (int i = 0; i < board[arylst].length; i++)
                {
                    foo += board[arylst][i];
                }
            }
        }
    }

    public static void printBoard() 
    {
        for (int[] board1 : board)
        {
            for (int i = 0; i < board1.length; i++)
            {
                if (board1[i] >= 0 )
                {
                    System.out.print(". ");
                }
                else if ((board1[i] == -2 ))
                {
                    System.out.print("~ ");
                }
                else
                {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
    }
    
    
    public static void gamePlay() 
    {
        int score = 0;
        Scanner userInputThing = new Scanner(System.in);
        while (score < 17)
        {
            System.out.println("Choose the horizontal point on the grid");
            int horizon = userInputThing.nextInt();
            System.out.println("Choose the vertical point on the grid");
            int vertical = userInputThing.nextInt();
            if (board[vertical-1][horizon-1] > 0 && board[vertical-1][horizon-1] < 6 )
            {
                score++;
                System.out.println("You got a hit! \n Your score is " + score);
                board[vertical-1][horizon-1] = -1;
                printBoard();
            }
            else if (board[vertical-1][horizon-1] == 0 )
            {
                System.out.println("You missed.");
                board[vertical-1][horizon-1] = -2;
                printBoard();
            }
            else
            {
                System.out.println("You have already shot here or you entered an invalid number");
            }
        }
        System.out.println("You have won!");
        
    }

    public static void main(String[] args) 
    {
        populateBoard();
        printBoard();
        gamePlay();
    }

}
