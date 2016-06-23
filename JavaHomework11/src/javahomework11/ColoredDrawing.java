/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework11;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author YYKF
 */
public class ColoredDrawing extends ArrayList
{
    private ArrayList<Point> points = new ArrayList<Point>();
    private Color color;
    private float lineThickness;

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the lineThickness
     */
    public float getLineThickness() {
        return lineThickness;
    }

    /**
     * @param lineThickness the lineThickness to set
     */
    public void setLineThickness(float lineThickness) {
        this.lineThickness = lineThickness;
    }

    /**
     * @return the points
     */
    public ArrayList<Point> getPoints() {
        return points;
    }
    
    public void add(Point point)
    {
        points.add(point);
    }
}
