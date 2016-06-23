/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing;

import java.util.Stack;

/**
 *
 * @author YYKF
 */
public class UndoRedoManager
{
    private static UndoRedoManager instance;
    Stack<DrawingCommand> undoStack = new Stack();
    Stack<DrawingCommand> redoStack = new Stack();

    private UndoRedoManager()
    {
    }
    public boolean undoEmpty()
    {
        return undoStack.empty();
    }
    
    public boolean redoEmpty()
    {
        return redoStack.empty();
    }
    public static UndoRedoManager getInstance()
    {
        if(instance == null)
            instance = new UndoRedoManager();
        
        return instance;
    }
     
    public void undo()
    {
        if(undoStack.empty())
            return;
        DrawingCommand poppedCommand = undoStack.pop();
        poppedCommand.undo();
        redoStack.push(poppedCommand);

    }
    
    public void redo()
    {
         if(redoStack.empty())
            return;
        DrawingCommand poppedCommand = redoStack.pop();   
        poppedCommand.redo();
        undoStack.push(poppedCommand);
    }
    public void execute(DrawingCommand command)
    {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }
}
