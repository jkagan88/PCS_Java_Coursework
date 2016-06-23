package javahomework6;

import java.util.stream.IntStream;

/**
 *
 * @author YYKF
 */
public class JavaHomework6
{
    
    public static int calculateAverage(int numbers[])
    {
        int sum = IntStream.of(numbers).sum();
        int avrg =sum / numbers.length;
        System.out.print(avrg);
        return avrg;
    }
    
    public static int grade(int numbers[])
    {
        int sum = IntStream.of(numbers).sum();
        int avrg =sum / numbers.length;
        char foo;
        if (avrg>90)
        {
            foo = 'A';
        }
        else if (avrg>80)
        {
            foo = 'B';
        }
        else if (avrg>70)
        {
            foo = 'C';
        }
        else if (avrg>60)
        {
            foo = 'D';
        }
        else
        {
            foo = 'F';
        }
        System.out.print(" Grade " + foo);
        return avrg;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //24. Loop through an array and print out 3 names
        String names[] = {"Tom","Dick","Harry"};
        
        int arrayLength = names.length;
        for (int i = 0; i<arrayLength; i++)
        {
            System.out.println(names[i]);
        }
        
        
        //25. Loop through an array of scores and print them out
        int theNumber = (int)(Math.random()*40)+60;
        int scores[] = new int[8];
        
        int arrayLength2 = scores.length;
        for (int i2 = 0; i2<arrayLength2; i2++)    
        {
            scores[i2] = theNumber;
            System.out.println(scores[i2]);
            theNumber = (int)(Math.random()*40)+60;
        }
        
        //26. Calculates and returns the average of all the values contained in the array
        int mainAvgs = calculateAverage(scores);

        System.out.println();
        //27. Combile all of the above into a single program  
        //28. Add another method for Grades
        String testNames[] ={"Tom","Dick","Harry"};        
        for(int a = 0; a<testNames.length; a++)
        {  
            System.out.print(testNames[a] + " ");
            
            for (int i2 = 0; i2<arrayLength2; i2++)    
            {
                scores[i2] = theNumber; 
                System.out.print(scores[i2] + " ");
                theNumber = (int)(Math.random()*40)+60;
            }
        System.out.print(" Average " );
        calculateAverage(scores);
        grade(scores);
        System.out.println();
        }
    }
    
}
