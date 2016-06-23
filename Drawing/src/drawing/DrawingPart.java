/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class DrawingPart implements Serializable
{
    ArrayList<Point> points = new ArrayList<Point>();
    Color color;
    float lineThickness;
    transient int counter = 5;

    public ArrayList<Point> getPoints()
    {
        return points;
    }

    public void add(Point point)
    {
        points.add(point);
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public float getLineThickness()
    {
        return lineThickness;
    }

    public void setLineThickness(float lineThickness)
    {
        this.lineThickness = lineThickness;
    }
}
