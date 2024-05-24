package com.abcd;
import com.abcd.RecipesOperation;
import com.abcd.SelectOperation;
import com.abcd.UpdateRecipe;
import com.abcd.JDBCUtil;

import java.sql.SQLException;
import java.util.Scanner;

public class MainApplicationLaunch {
    public static void main(String[] args) {
    	System.out.println("Personal Recipe Management Application");
    	Scanner input=new Scanner(System.in);
    	System.out.println("Enter an option to continue:1) Add recipe 2) Update recipe 3)To select recipe asmain ingredient 4)Delete the recipe5)Quit application ");
    	int inputOption=input.nextInt();
    	switch( inputOption) {
    		case 1:
        try {
            RecipesOperation recipesOperation = new RecipesOperation();
            recipesOperation.addRecipes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        break;
        
    	
    	case 2: {
    		try {
    			UpdateRecipe recipe_updation= new UpdateRecipe();
    			recipe_updation.updateRecipes();
    		}catch (SQLException e) {
                e.printStackTrace();
            }
            break;
    	}
            case 3:try {
    			SelectOperation select_recipe= new SelectOperation();
                  select_recipe.selectRecipe();
}catch (SQLException e) {
                e.printStackTrace();
            }
            break;
    	}
           
        	   
    	}
    	
}