package com.abcd;
import com.abcd.RecipesOperation;
import com.abcd.JDBCUtil;

import java.sql.SQLException;

public class MainApplicationLaunch {
    public static void main(String[] args) {
        try {
            RecipesOperation recipesOperation = new RecipesOperation();
            recipesOperation.addRecipes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}