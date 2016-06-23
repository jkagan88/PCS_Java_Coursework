/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

/**
 *
 * @author YYKF
 */
public class CreateDrawingPartCommand implements DrawingCommand
{
    DrawingPart drawingPart;
    Drawing  drawing;

    public CreateDrawingPartCommand(DrawingPart drawingPart, Drawing drawing)
    {
        this.drawingPart = drawingPart;
        this.drawing = drawing;
    }
    @Override
    public void execute()
    {
        drawing.add(drawingPart);
    }
    @Override
    public void undo()
    {
        drawing.remove(drawingPart);
    }
    @Override
    public void redo()
    {
        execute();
    }
}
