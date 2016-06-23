
package javaclass5;

/**
 *
 * @author YYKF
 */
public class JavaClass5
{
    
    public static int addTwoNumbers(int one, int two)
    {
        int answer = one + two;
        System.out.println(one + " + " + two + " = " + answer);
        return answer;
    }
    
    public static void printHello(int number)
    {
        System.out.println("Hello! Hello! number " + number);
        number = 23;
    }

    public static void main(String[] args) 
    {
        System.out.println("Hello World");
        printHello(5);
        printHello(65);
        addTwoNumbers(5,6);
        addTwoNumbers(43,32);
        
        int foo = addTwoNumbers(1,2);
        System.out.println(foo);
    }
    
}
