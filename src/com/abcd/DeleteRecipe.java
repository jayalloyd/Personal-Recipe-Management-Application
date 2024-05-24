package com.abcd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

@FunctionalInterface
interface Operations4 {
    void deleteRecipes() throws SQLException;
}

public class DeleteRecipe implements Operations4 {
    public DeleteRecipe() throws SQLException {
        System.out.println("Operation4-update Started");
    }

    @Override
    public void deleteRecipes() throws SQLException {
        String sql = "DELETE FROM  Recipe  WHERE id = ?";
        Connection connect = null;
        PreparedStatement pstatement = null;
        
        try {
            connect = JDBCUtil.getConnection();
            pstatement = connect.prepareStatement(sql);
            
            System.out.println("Please enter the following data:");
            Scanner input = new Scanner(System.in);
            System.out.println("Enter id to be Deleted:");
            int id = input.nextInt();
//            input.nextLine(); // Consume newline left-over
//            System.out.println("Enter dish name:");
//            String dish_name = input.nextLine();
//            System.out.println("Enter cuisine:");
//            String cuisine = input.nextLine();
//            System.out.println("Enter URL:");
//            String url = input.nextLine();
//            System.out.println("Enter main ingredient:");
//            String main_ingredient = input.nextLine();
            input.close();
            
//            pstatement.setString(1, dish_name);
//            pstatement.setString(2, cuisine);
//            pstatement.setString(3, url);
//            pstatement.setString(4, main_ingredient);
            pstatement.setInt(1, id); // Set the id last, as it is the last placeholder
            
            System.out.println("DELETION continuing");
            
            int rowsAffected = pstatement.executeUpdate();
                  System.out.println("Rows affected: " + rowsAffected);
                  if(rowsAffected==0) {
                	  System.out.println("Unable to delete");
                	  
                  }else {
                	  System.out.println("Deletion succesful");
                  }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connect, pstatement);
        }
    }
}
