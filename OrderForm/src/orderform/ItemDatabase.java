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
public class ItemDatabase
{
    private Item [] itemArray = new Item [100];
    
    public ItemDatabase()
    {
        Item item1 = new Item();
        item1.setName("Lenovo");
        item1.setDescription("Computer");
        item1.setPrice(200);
        itemArray[0] = item1;
        
        Item item2 = new Item();
        item2.setName("IBM");
        item2.setDescription("Computer");
        item2.setPrice(500);
        itemArray[1] = item2;
        
        Item item3 = new Item();
        item3.setName("Dell");
        item3.setDescription("Computer");
        item3.setPrice(600);
        itemArray[2] = item3;
        

        
    }
    //Method for finding items by name
    public Item findByName(String foo)
    {
       int e = 0;
       while (getItemArray()[e].getName() != foo && e<getItemArray().length)
       {
           e++;
       }
       if(getItemArray()[e].getName().equalsIgnoreCase(foo))
           return getItemArray()[e];
       else
           return null;
           
    }
    //Method for finding items by id
    public Item findByID(int foo)
    {
       int e = 0;
       while (getItemArray()[e].getID() != foo && e<getItemArray().length)
       {
           e++;
       }
       if(getItemArray()[e].getID() == foo)
           return getItemArray()[e];
       else
           return null;
           
    }

    /**
     * @return the itemArray
     */
    public Item[] getItemArray() {
        return itemArray;
    }

    /**
     * @param itemArray the itemArray to set
     */
    public void setItemArray(Item[] itemArray) {
        this.setItemArray(itemArray);
    }

    /**
     * @param itemArray the itemArray to set
     */
    public void setItemArray(Item[] itemArray) {
        this.itemArray = itemArray;
    }


}
