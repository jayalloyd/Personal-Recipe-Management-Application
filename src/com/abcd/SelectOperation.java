package com.abcd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

@FunctionalInterface
interface Operations3 {
    void selectRecipe() throws SQLException;
}

public class SelectOperation implements Operations3 {
    public SelectOperation() throws SQLException {
        System.out.println("Operation3-update Started");
    }

    public void selectRecipe() throws SQLException {
        String sql = "SELECT dish_name, url, cuisine FROM Recipe WHERE main_ingredient = ?";
        Connection connect = null;
        PreparedStatement pstatement = null;

        try {
            connect = JDBCUtil.getConnection();
            pstatement = connect.prepareStatement(sql);

            System.out.println("Please enter the main ingredient name to be searched:");
            Scanner input = new Scanner(System.in);
            String main_ingredient = input.nextLine();

            pstatement.setString(1, main_ingredient);            
            System.out.println("Search continuing");

            ResultSet rs = pstatement.executeQuery();
            boolean recordsFound = false;
            while (rs.next()) {
                String dish_name = rs.getString("dish_name");
                String cuisine = rs.getString("cuisine");
                String url = rs.getString("url");
                System.out.println("Dish Name: " + dish_name + ", Cuisine: " + cuisine + ", URL: " + url);
                recordsFound = true;
            }
            if (!recordsFound) {
                System.out.println("No records found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connect, pstatement);
        }
    }
}
