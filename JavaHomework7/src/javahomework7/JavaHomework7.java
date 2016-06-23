/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework7;

/**
 *
 * @author YYKF
 */
public class JavaHomework7
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       int [][] batlsp = 
       {
           {0,0,0,0,0,0,0,0,0,0},
           {0,2,2,0,0,0,0,0,4,0},
           {0,0,0,0,0,0,0,0,4,0},
           {0,0,0,0,0,0,0,0,4,0},
           {0,0,5,5,5,5,5,0,4,0},
           {0,0,0,0,0,0,3,0,0,0},
           {0,0,0,0,0,0,3,0,0,0},
           {0,0,0,0,0,0,3,0,0,0},
           {0,3,3,3,0,0,0,0,0,0},
           {0,0,0,0,0,0,0,0,0,0}
        };
       for (int arylst = 0; arylst < batlsp.length; arylst++)
       {
            for (int i = 0; i < batlsp[arylst].length; i++)
            {
                System.out.print(batlsp[arylst][i] + " ");
            }
            System.out.println();
       }
    }
    
}
