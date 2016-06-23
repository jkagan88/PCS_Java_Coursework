/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.Arrays;

/**
 *
 * @author YYKF
 */
public class Sorting
{
    public static void print(int [] numbers)
    {
        for (int i = 0; i < numbers.length; i++)
        {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();
    }
     public static int binarySearch(int number, int [] numbers)
     {
         int low = 0;
         int hi =  numbers.length-1;
         
         while(low < hi)
         {
            int mid = (low+hi)/2;

            if(numbers[mid] > number)
            {
                hi = mid-1;
            }
            else if(numbers[mid] < number)
            {
                low = mid+1;
            }
            else
            {
                return mid;
            }
         }
         return -1;
     }
     
    public static void bubbleSort(int [] numbers)
    {
        for (int i = 1; i < numbers.length; i++)
        {
            boolean swap = false;
            for (int j = 0; j < numbers.length-i; j++)
            {   
                if (numbers[j+1] < numbers[j])
                {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
                
            }
            if(!swap)
            {
                break;
            }
        }      
    }
     
    public static void insertionSort(int [] numbers)
    {
        for (int i = 1; i < numbers.length; i++)
        {
            int temp = numbers[i];
            int j = i-1;
            while(j >= 0 && numbers[j] > temp)
            {
                numbers[j+1] = numbers[j];
                 j--;
            }
            numbers[j+1] = temp;
        }
    }
    public static void selectionSort(int [] numbers)
    {
        //int unSorted = 0;
        int minIndex = 0;
        for (int unSorted = 0; unSorted < numbers.length; unSorted++)
        {
            minIndex = unSorted;
            for (int i = unSorted; i < numbers.length; i++)
            {
                if(numbers[i]< numbers[minIndex])
                    minIndex = i;
            }
            int temp = numbers[minIndex];
            numbers[minIndex] = numbers[unSorted];
            numbers[unSorted] = temp;
        }
        //System.out.println(numbers[minIndex]);
    }
    
    public static void main(String[] args) 
    {
	int [] numbers = new int[40];
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = (int) (Math.random()*40);
        }
 
        
       
        //selectionSort(numbers);
        //insertionSort(numbers);
        print(numbers);
        bubbleSort(numbers);
        print(numbers);
        //Arrays.sort(numbers); 
        int index = binarySearch(numbers[17], numbers);
        System.out.println(numbers[17] + " is at slot " +index);
        //print(numbers);
    }
}
