/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice2;

/**
 *
 * @author YYKF
 */
public class Stars
{
    public static void stars (int count, char whichChar)
    {   
        String starList = "";
        for (int i=0; i<count; i++)
        {
            starList += whichChar + " ";
        }
        System.out.println(starList);
    }
}
