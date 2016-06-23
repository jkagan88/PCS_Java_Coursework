/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YYKF
 */
public class UsingSQL
{
    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/real_estate", "test", "Fishguys1");
    }
    
    public static void printResultSet(ResultSet rs)
    {
        try
        {
            while(rs.next())
            {
                System.out.print("First name: " + rs.getString("first_name"));
                System.out.println("   Last name: " + rs.getString("last_name"));
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(UsingSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void getRenters(int index)
    {
        try (Connection con = getConnection())
        {            
            Statement createStatement = con.createStatement();
            String sql = "Select r.first_name, r.last_name " +
                    "FROM renters r " +
                    "WHERE r.id= '" + index + "'";
            ResultSet rs = createStatement.executeQuery(sql);
            printResultSet(rs);
        } catch (ClassNotFoundException | SQLException ex)
        {
            ex.printStackTrace();
        } 
    }
    
    public static void main(String[] args) 
    {
        getRenters(2);
    }
    
}
