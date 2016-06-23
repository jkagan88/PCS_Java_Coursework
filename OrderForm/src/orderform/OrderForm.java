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
public class OrderForm
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Order order2 = new Order(new Customer("Rich", new Address("987 any Avenue","Brooklyn","NY","11204")));
        ItemDatabase itemDatabase = new ItemDatabase();
        order2.addItem(itemDatabase.findByName("Dell"));
        order2.addItem(itemDatabase.findByName("Lenovo"));
        order2.addItem(itemDatabase.findByID(101));
        

        order2.print();
    }
    
}
