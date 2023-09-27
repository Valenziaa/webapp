/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Brand;

/**
 *
 * @author march
 */
public class DBConnection {

    public boolean insertNewBrand(Brand brand) {
        boolean result = false;
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/brand",
                    "root", "1234");

            Statement statement;
            statement = connection.createStatement();



            String query = "INSERT INTO brands "
                    + "(Name, Type, Price) "
                    + "VALUES('"
                    + brand.getName() + "','"
                    + brand.getType() + "','"
                    
                    
                    + brand.getPrice() + ")";
            System.out.println("........SQL: " + query);

            int i = statement.executeUpdate(query);	// executeUpdate returns row count ****
            if (i != 0) {
                result = true;
            }
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

        return result;
    }
     public void testRetrieve() {
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/brand",
                    "root", "1234");

            Statement statement;
            statement = connection.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                    "select name from brands");
            String name;
            while (resultSet.next()) {
                name = resultSet.getString("name").trim();
                System.out.println(" name : " + name);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }


    
}
