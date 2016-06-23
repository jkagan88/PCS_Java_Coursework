package javaclass6;

/**
 *
 * @author YYKF
 */
public class JavaClass6
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String s = "Hello";
        String s2 = new String("Hello");
        if(s.equals(s2))
        {
            System.out.println("they are the same");
        }
        else
        {
            System.out.println("they are not the same");
        }
        
        
        
        if(s==s2)
        {
            System.out.println("they are the same");
        }
        else
        {
            System.out.println("they are not the same");
        }
        
        int [] myAray = new int[5];
        myAray[0]=4;
        myAray[1]=24;
        myAray[2]=2;
        myAray[3]=88;
        myAray[4]=6;
        
        int arrayLength = myAray.length;
        System.out.println(arrayLength);
        
        for(int i = 0; i < arrayLength; i++)
        {
            System.out.println(myAray[i]);
        }
        
        
        
        
    }
    
  
}

