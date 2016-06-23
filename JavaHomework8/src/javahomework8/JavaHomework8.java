/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework8;

/**
 *
 * @author YYKF
 */
public class JavaHomework8
{   

    
    public static String appetizer()
    {
        String [] food = {"grilled fish", "fried fish", "baked fish"};
        int mealRandom = (int) (Math.random() * 3);
        String choice  = food[mealRandom];
        return choice;
    }
    
    public static String entree()
    {
        String [] food = {"Steak", "Chicken", "Brisket"};
        int mealRandom = (int) (Math.random() * 3);
        String choice  = food[mealRandom];
        return choice;
    }
    
        public static String dessert()
    {
        String [] food = {"Vanilla icecream", "Chocolate icecream", "Cake"};
        int mealRandom = (int) (Math.random() * 3);
        String choice  = food[mealRandom];
        return choice;
    }
        
        public static String beverage()
    {
        String [] food = {"Water", "Seltzer", "CocaCola"};
        int mealRandom = (int) (Math.random() * 3);
        String choice  = food[mealRandom];
        return choice;
    }
        
        public static void generateMeal()
    { 
        System.out.println(appetizer());
        System.out.println(entree());
        System.out.println(dessert());
        System.out.println(beverage() + "\n");
    }
                
    public static void pattern()
    {
        //30. 31. Code to store and print out an checkerboard pattern
        char [][] charPattern = new char[8][8];
        for (int i = 0; i < charPattern.length; i++)
        {
            for (int k = 0; k < charPattern[i].length; k++)
            { 
                if (i % 2  == 0 && k % 2 == 0 || i % 2 != 0 && k % 2 != 0)
                {
                        charPattern[i][k] = '#';
                }
                else
                {
                        charPattern[i][k] = '*';
                }
                System.out.print(charPattern[i][k] + " ");

            }
            System.out.println();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    { 
        pattern();
        generateMeal();  
        generateMeal(); 
        generateMeal(); 
        generateMeal(); 
    }
}
