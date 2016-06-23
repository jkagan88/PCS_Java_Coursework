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
public class Classroom
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //class/static variable accessable without an instance
        Student.maxAge = 30;
        
        //even in the student class an instace variable is not 
        //accessabe in a static method
        //name = "jack";
        
        
        Student a = new Student();
        //name is private, not accessable outside of Student class
        //a.name = "joe";
        a.SetHisName("joe");
        a.marks[0] = 99;
        String name = a.GetHisName();
        
        Student b = new Student();
        //b.name = "jim";
        b.setName("jim");
        b.setAge(25);
        b.marks[0] = 79;
        b.marks[1] = 90;
        b.print(b);
        
//        Student c;
//        c.SetHisName("jack");
    }
    
}
