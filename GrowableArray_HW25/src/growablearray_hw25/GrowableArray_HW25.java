/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package growablearray_hw25;

import java.sql.Array;

/**
 *
 * @author YYKF
 */
public class GrowableArray_HW25
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        GrowableArray ga = new GrowableArray();
        ga.add(6);
        ga.add(4);
        ga.add(2);

        ga.sort();
        System.out.println(ga.binarySearch(6));
        System.out.println(ga.binarySearch(4));
        System.out.println(ga.binarySearch(2));
    }
    
}
