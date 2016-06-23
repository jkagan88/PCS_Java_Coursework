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
public class Order
{
    private Customer customer;
    private Item [] items = new Item [100];
    private int orderNumber;
    static int orderNumberCounter = 100;
    
    public Order(Customer customer, Item... items)
    {
        //call the constructor that takes a customer
        this(customer);
        AddItems(items);
    }
    
    public Order(Customer customer)
    {
        //call the constructor that takes no arguments
        this();
        setCustomer(customer);
    }
    
    public Order()
    {
        //you could have called the constructor that takes a customer amd an item array
        //passing a empty new Customer, and an empty new Item array
        //this(new Customer(), new Item []{});
        
        //System.out.println("Constructor called");
        orderNumber = orderNumberCounter++;
    }
    
    public void addItem(Item item)
    {
        for(int i = 0; i < items.length; i++)
        {
            if (items[i] == null)
            {
                 items[i] = item;
                 break;
            }
        }   
    }
    public void AddItems(Item... items)
    {
        for (Item item : items)
        {
           addItem(item);
        }
    }
    public void print()
    {
        System.out.println("Order number: " +orderNumber);
        customer.print();
        if(items != null)
        {
            for (Item item : items)
            {
                if(item != null)
                {
                    item.print();
                }
                else //not needed
                {
                    break;
                }
            }
        }
        System.out.println("Total: $" + getTotal());
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    //make a copy and return
    public Item[] getItems()
    {
        Item [] itemsCopy = new Item [items.length];
        for (int i = 0; i < items.length; i++)
        {
            itemsCopy[i] = items[i];
        }
        return itemsCopy;
    }

//    public void setItems(Item[] items)
//    {
//        this.items = items;
//    }
    
    public double getTotal()
    {
        double total = 0.0;
        if(items != null)
        {
            for (Item item : items)
            {
                if(item != null)
                    total += item.getPrice();
            }
        }
        return total;
    }

    /**
     * @return the orderNumber
     */
    public int getOrderNumber()
    {
        return orderNumber;
    }

    /**
     * @param orderNumber the orderNumber to set
     */
//    public void setOrderNumber(int orderNumber)
//    {
//        this.orderNumber = orderNumber;
//    }
}
