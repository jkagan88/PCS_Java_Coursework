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
public class Square extends Shapes
{
    private int size;
    
    public Square()
    {
        this(5);
    }
    
    public Square(int size)
    {
        this.size = size;
    }
    
    public void draw()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.println();
            for (int j = 0; j < size; j++)
            {
                System.out.print("@ ");
            }
        }
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
}
