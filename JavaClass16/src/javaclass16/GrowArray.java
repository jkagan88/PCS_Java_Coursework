/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclass16;

/**
 *
 * @author YYKF
 */
public class GrowArray
{
    int [] myArray = new int [2];
    int index = 0;
    
    public void add(int newNumber)
    {
        //int [] myArray = new int [2];
        for (int i = 0; i < 100; i++)
        {
            if (index >= myArray.length)
            {
                System.out.println("Need to grow");
                int [] temp = new int[myArray.length * 2];
                for (int j = 0; j < myArray.length; j++)
                {
                    temp[j] = myArray[j];
                }
                myArray = temp;
            }
            myArray[index++] = newNumber; 
            //System.out.println(myArray[i]);
        }
    }
    
    
    public int size()
    {
        return index;
    }
    
    
    public int get(int index)
    {
        return myArray[index];
    }
}
