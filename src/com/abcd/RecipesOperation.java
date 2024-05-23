package com.abcd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.abcd.JDBCUtil;

interface Operations {
    void addRecipes() throws SQLException;
}

public class RecipesOperation implements Operations {
    public RecipesOperation() throws SQLException {
        System.out.println("Operation Started");
    }

    @Override
    public void addRecipes() throws SQLException {
        String sql = "INSERT INTO Recipe (dish_name, cuisine, url, main_ingredient) VALUES (?, ?, ?, ?)";
        Connection connect = null;
        PreparedStatement pstatement = null;
        
        try {
            connect = JDBCUtil.getConnection();
            pstatement = connect.prepareStatement(sql);
            
            System.out.println("Please enter the following data:");
            Scanner input = new Scanner(System.in);
            System.out.println("Enter dish name:");
            String dish_name = input.next();
            System.out.println("Enter cuisine:");
            String cuisine = input.next();
            System.out.println("Enter URL:");
            String url = input.next();
            System.out.println("Enter main ingredient:");
            String main_ingredient = input.next();
            
            input.close();
            
            pstatement.setString(1, dish_name);
            pstatement.setString(2, cuisine);
            pstatement.setString(3, url);
            pstatement.setString(4, main_ingredient);
            int rowsAffected = pstatement.executeUpdate();
            
            if (rowsAffected == 0) {
                System.out.println("Data insertion unsuccessful");
            } else {
                System.out.println("Data inserted successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connect, pstatement);
        }
    }
}
