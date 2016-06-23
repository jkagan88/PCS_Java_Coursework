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
public class JavaHomework23
{

//    static String end = "";
//    
//    public static String stringReverse(String string)
//    {     
//        char i = string.charAt(string.length()-1);
//        string = string.substring(0, string.length()-1);
//        end = end + i;
//        if (string.length() > 0)
//        {
//            return stringReverse(string);
//        }
//        else
//            return end;
//    }
    
    
    public static void main(String[] args) 
    {
        StringReverser stringRev = new StringReverser();
        System.out.println(stringRev.stringReverse("987654321"));
        //System.out.println(stringRev.stringReverse(""));
        System.out.println(stringRev.stringReverse("abcdefg"));
    }
    
}
