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
public class Address
{
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address()
    {
        
    }
    
    public Address(String street, String city,String state,String zip )
    {
        this.street = street;
        this.state = state;
        this.city = city;
        this.zip = zip;
    }
    /**
     * @return the street
     */
    public String getStreet()
    {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street)
    {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState()
    {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public String getZip()
    {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip)
    {
        if(zip != null && zip.length() == 5)
        {
            this.zip = zip;
        }
    }
    
    public void print()
    {
        System.out.println("Street: " + street);
        System.out.println("City: " + getCity()); 
        System.out.println("State: " + state); 
        System.out.println("Zip: " + zip); 
    }
}
