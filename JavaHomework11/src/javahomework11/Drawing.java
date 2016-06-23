/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahomework11;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author YYKF
 */
public class Drawing extends JFrame
{
    ArrayList<ColoredDrawing>lines = new ArrayList<ColoredDrawing>();
    ArrayList<Point> currentLine;
    public Drawing()
    {
        setExtendedState(MAXIMIZED_BOTH);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
      add(new DrawingCanvas(), BorderLayout.CENTER);
    }
    
    


 
    public static void main(String[] args) {
		new Drawing().setVisible(true);
	}
    
    public class DrawingCanvas extends JPanel
    {
        
        public DrawingCanvas()
        {
              this.addMouseMotionListener(new MouseMotionAdapter(){

                @Override
                public void mouseDragged(MouseEvent e)
                {
                     currentLine.add(new Point(e.getX(), e.getY()));
                     repaint();
               }
            });

            addMouseListener(new MouseAdapter(){

                @Override
                public void mousePressed(MouseEvent e)
                {
                    currentLine = new ColoredDrawing();
                    lines.add(currentLine);
                    //ColoredDrawing points = new ColoredDrawing();
                    currentLine.setColor(Color.yellow);
                    currentLine.setLineThickness(30.0f);
                    lines.add(points);
                    currentLine = points;
                    currentLine.add(new Point(e.getX(), e.getY()));
                    repaint();
                }

    //            @Override
    //            public void mouseReleased(MouseEvent e)
    //            {
    //                 System.out.println("released " + e.getX() + "," + e.getY());
    //            }

            });
        }
           @Override
        public void paint(Graphics graphics)
        { 
            graphics.setColor(Color.ORANGE);
            Graphics2D g2d = (Graphics2D)graphics;
            g2d.setStroke(new BasicStroke(5));
            for (ArrayList<Point> points : lines)
            {
                if(points.isEmpty())
                    return;

                Point lastLocation = points.get(0);
                for (int i = 1; i < points.size(); i++)
                {
                    Point currentPoint = points.get(i);
                    graphics.drawLine(lastLocation.x, lastLocation.y, currentPoint.x, currentPoint.y);
                    lastLocation = currentPoint;
                }
            }
    //        for (int i = 0; i < 1000; i++)
    //        {
    //            int sx = (int)(Math.random()*1000);
    //            int sy = (int)(Math.random()*1000);
    //            int ex = (int)(Math.random()*1000);
    //            int ey = (int)(Math.random()*1000);
    //            graphics.drawLine(sx, sy, ex, ey);
    //        }
            //graphics.drawLine(200, 200, 400, 400);
        }
    }
}