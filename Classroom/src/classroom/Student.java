/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroom;

/**
 *
 * @author YYKF
 */
public class Student
{
    public static int maxAge = 25;
    private String name;
    public int [] marks = new int [8];
    private int age;
    
    public void print(Student foo)
    {
        System.out.println("name: " + foo.name);
        if (foo.age != 0)
        {      
            System.out.println("age: " + foo.age);
        }
        for (int i = 0; i<marks.length; i++)
        {
            if (marks[i] != 0)
            {
                System.out.println(marks[i]);
            }
            else
            {
                break;
            }
        }
        
    }
    
    public String GetHisName()
    {
        return name;
    }
    
     public void SetHisName(String aName)
    {
        if(aName != null && !aName.isEmpty())
        {
            name = aName;
        }
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}
