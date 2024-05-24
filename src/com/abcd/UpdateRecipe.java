package com.abcd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

@FunctionalInterface
interface Operations2 {
    void updateRecipes() throws SQLException;
}

public class UpdateRecipe implements Operations2 {
    public UpdateRecipe() throws SQLException {
        System.out.println("Operation2-update Started");
    }

    @Override
    public void updateRecipes() throws SQLException {
        String sql = "UPDATE Recipe SET dish_name = ?, cuisine = ?, url = ?, main_ingredient = ? WHERE id = ?";
        Connection connect = null;
        PreparedStatement pstatement = null;
        
        try {
            connect = JDBCUtil.getConnection();
            pstatement = connect.prepareStatement(sql);
            
            System.out.println("Please enter the following data:");
            Scanner input = new Scanner(System.in);
            System.out.println("Enter id to be updated:");
            int id = input.nextInt();
            input.nextLine(); // Consume newline left-over
            System.out.println("Enter dish name:");
            String dish_name = input.nextLine();
            System.out.println("Enter cuisine:");
            String cuisine = input.nextLine();
            System.out.println("Enter URL:");
            String url = input.nextLine();
            System.out.println("Enter main ingredient:");
            String main_ingredient = input.nextLine();
            input.close();
            
            pstatement.setString(1, dish_name);
            pstatement.setString(2, cuisine);
            pstatement.setString(3, url);
            pstatement.setString(4, main_ingredient);
            pstatement.setInt(5, id); // Set the id last, as it is the last placeholder
            
            System.out.println("Updation continuing");
            
            int rowsAffected = pstatement.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connect, pstatement);
        }
    }
}
