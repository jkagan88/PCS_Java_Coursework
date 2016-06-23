/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package growablearray_hw25;

/**
 *
 * @author YYKF
 */
public class GrowableArray
{
    int [] myArray;
    int index = 0;
    
    public GrowableArray(int initialSize)
    {
        myArray = new int [initialSize];
    }
    
    public GrowableArray()
    {
        this(10);
    }
    

    public void sort()
    {
        for (int i = 1; i < index; i++)
        {
            int temp = myArray[i];
            int j = i-1;
            while(j >= 0 && myArray[j] > temp)
            {
                myArray[j+1] = myArray[j];
                 j--;
            }
            myArray[j+1] = temp;
        }
    }
    
    public int binarySearch(int number)
     {
         int low = 0;
         int hi =  index-1;
         
         while(low <= hi)
         {
            int mid = (low+hi)/2;

            if(myArray[mid] > number)
            {
                hi = mid-1;
            }
            else if(myArray[mid] < number)
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
    
     public void add(int item)
     {
        if(index >= myArray.length)
        {
            //need to grow
            System.out.println("Need to grow");
            int [] temp = new int [myArray.length * 2];
            for (int j = 0; j < myArray.length; j++)
            {
                temp[j] = myArray[j];
            }
            myArray = temp;
        }
        myArray[index++] = item;
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
