/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework14;

/**
 *
 * @author YYKF
 */
public class JavaHomework14
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Shapes [] shapeAry = 
        {
            new Circle(3),
            new Circle(),
            new Square(3),
            new Square()
        };
        for (Shapes shape: shapeAry)
        {
            shape.draw();
        }
        

    }
    
}
