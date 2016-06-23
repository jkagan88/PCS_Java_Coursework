/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import java.awt.Color;

/**
 *
 * @author YYKF
 */
public class SetBackgroundColorCommand implements DrawingCommand
{
    Color color;
    Color oldColor;
    Drawing drawing;

    public SetBackgroundColorCommand(Color color, Drawing drawing)
    {
        this.color = color;
        oldColor = drawing.getDrawingBackground();
        this.drawing = drawing;
    }

    @Override
    public void execute()
    {
        drawing.setDrawingBackground(color);
    }

    @Override
    public void undo()
    {
        drawing.setDrawingBackground(oldColor);
    }

    @Override
    public void redo()
    {
        execute();
    }
    
}
