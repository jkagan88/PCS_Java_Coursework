/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/**
 *
 * @author YYKF
 */
public class Arguments
{
    private int left;
    private int right;
    private int answer;
    
    public static void show(Arguments argument)
    {
        System.out.println("left: " + argument.left + " right: " +  argument.right + " answer: " + argument.answer);
    }
    
    
    public Arguments()
    {
        
    }
    
    public Arguments(int left, int right)
    {
        this.left = left;
        this.right = right;
    }

    /**
     * @return the left
     */
    public int getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(int left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public int getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(int right) {
        this.right = right;
    }

    /**
     * @return the answer
     */
    public int getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(int answer) {
        this.answer = answer;
    }
    
    
}
