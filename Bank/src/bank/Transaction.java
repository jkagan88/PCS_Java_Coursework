/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author YYKF
 */
public class Transaction
{
    private String date;
    private String type;
    private double action;
    
    public Transaction()
    {
        
    }
    
    public Transaction(String date, String type, double action)
    {
        this.date = date;
        this.type = type;
        this.action = action;
    }
    
    public String print()
    {   
        System.out.println(getDate() + ":    " + getType() + " $" + getAction());
        
        //String parsedAction = Double.toString(getAction());
        String parsedTransaction = (getDate() + ":    " + getType() + " $" + getAction() + "\n");
        return parsedTransaction;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return getType();
    }

    /**
     * @param time the time to set
     */
    public void setTime(String type) {
        this.setType(type);
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the action
     */
    public double getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(double action) {
        this.action = action;
    }
}
