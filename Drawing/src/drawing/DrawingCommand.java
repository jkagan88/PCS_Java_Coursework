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
public interface DrawingCommand
{
    public void execute();
    public void undo();
    public void redo();
}
