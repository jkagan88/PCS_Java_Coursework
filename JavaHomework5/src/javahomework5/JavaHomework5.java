package javahomework5;

/**
 *
 * @author YYKF
 */
public class JavaHomework5
{
    
    public static void printStars(int stars)
    {
        for (int cntr = 0; cntr<stars; cntr++)
        {
            System.out.print('*');
        }
        System.out.println();
    }


    public static void printChars(int theint, char thechar)
    {
        for (int cntr2 = 0; cntr2<theint; cntr2++)
        {
            System.out.print(thechar);
        }
        System.out.println();
    }
    
    
    public static int getDaysInMonth(int month, int year)
    {
        int days =-1;
        switch(month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
            {
                days = 31;
                //System.out.println("The month contains 31 days");
                break;
            }
            
            case 4:
            case 6:
            case 9:
            case 11:
            {
                days = 30;
                //System.out.println("The month contains 30 days");
                break;
            }
            
            case 2:
            {
                if (year % 4 == 0 && (year%100 != 0 || year%400 == 0))
                {
                    days = 29;
                    //System.out.println("The month contains 29 days");
                }
                else
                {
                    days = 28;
                    //System.out.println("The month contains 28 days");
                }
            }
                
        }
        return days;
    }
            
    
    public static void main(String[] args) 
    {
       printStars(5);
       printStars(2);
       printStars(1);
       printStars(6);
       printChars(6, 'r');
       printChars(1, '#');
       getDaysInMonth(2, 2000);
       getDaysInMonth(2, 1900);
       int returnValue = getDaysInMonth(2,2000);
       System.out.println(returnValue);
    }
    
}
