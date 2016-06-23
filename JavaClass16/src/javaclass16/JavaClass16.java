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
public class JavaClass16
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        GrowArray gw = new GrowArray();
        for (int i = 0; i<100; i++)
        {
            gw.add(i);
        }
        for (int i = 0; i<100; i++)
        {
            System.out.println(gw.get(i));
        }
        System.out.println(Integer.parseInt("55")+5);
    }  
}
