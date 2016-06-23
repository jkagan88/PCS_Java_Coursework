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
public class Circle extends Shapes
{
    private int radius;
    
    //Constructor that doesnt take in values
    public Circle()
    {
        radius = 5;
    }
    
    //Constructor that takes in a radius
    public Circle(int radius)
    {
        this.radius = radius;
    }
    
    public void draw()
    {
        System.out.println("Circle, radius " + radius);
    }
    /**
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
}
