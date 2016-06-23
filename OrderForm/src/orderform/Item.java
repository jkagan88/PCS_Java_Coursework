/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderform;

/**
 *
 * @author YYKF
 */
public class Item
{
    public Item()
    {
         this("", "", 0);
    }

    //
    public Item(String name, String description, int price)
    {
        this(name, description, price, true);
    }

    public Item(String name, String description, int price, boolean taxable)
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.taxable = taxable;
        ID = IDCounter++;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getPrice()
    {
        return (int)Math.round(price);
        //return (int)price;
    }
    
    public double getExactPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
    private String name;
    private String description;
    private double price;
    private boolean taxable;
    private int ID;
    static int IDCounter = 100;

    public boolean isTaxable()
    {
        return taxable;
    }

    public void setTaxable(boolean taxable)
    {
        this.taxable = taxable;
    }
    
    public void print()
    {   
        System.out.print(ID + " " + name);
        System.out.print(" " + this.description);
        System.out.print("  price: $" + price);

        if(isTaxable())
            System.out.print(" " + 'T');
        System.out.println();
    }
    
    //using ternery
    public void print2()
    {
        System.out.print(name);
        System.out.print(" " + this.description);
        System.out.print("  price: $" + price);
        //String taxString = taxable == true ? " T" : "";
        System.out.print(taxable == true ? " T" : "");
        System.out.println();
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }
}
