/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringreverser;

/**
 *
 * @author YYKF
 */
public class StringReverser
{
    String end = "";
    
    public String stringReverse(String string)
    {   
        char i = string.charAt(string.length()-1);
        string = string.substring(0, string.length()-1);
        end = end + i;
 
        if (string.length() > 0)
        {
            return stringReverse(string);
        }
        else
        {
            String end2 = end;
            end = "";
            return end2;
        }
    }
}
