/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.Stack;

/**
 *
 * @author YYKF
 */
public class UndoRedoManager
{
    private static UndoRedoManager instance;
    Stack<BankCommand> undoStack = new Stack();
    Stack<BankCommand> redoStack = new Stack();

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
        BankCommand poppedCommand = undoStack.pop();
        poppedCommand.undo();
        redoStack.push(poppedCommand);

    }
    
    public void redo()
    {
        if(redoStack.empty())
            return;
        BankCommand poppedCommand = redoStack.pop();   
        poppedCommand.redo();
        undoStack.push(poppedCommand);
    }
    public void execute(BankCommand command)
    {
        command.execute();
        undoStack.push(command);
        redoStack.clear();
    }
}
