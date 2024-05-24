package com.abcd;

import java.sql.SQLException;
import java.util.Scanner;

public class MainApplicationLaunch {
    public static void main(String[] args) {
        boolean menu = true;
        Scanner input = new Scanner(System.in);

        while (menu) {
            System.out.println("Personal Recipe Management Application");
            System.out.println("Enter an option to continue: 1) Add recipe 2) Update recipe 3) To select recipe by main ingredient 4) Delete the recipe 5) Quit application ");
            
            if (input.hasNextInt()) {
                int inputOption = input.nextInt();
                input.nextLine();  // Consume newline left-over

                switch (inputOption) {
                    case 1:
                        try {
                            RecipesOperation recipesOperation = new RecipesOperation();
                            recipesOperation.addRecipes();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            UpdateRecipe recipeUpdation = new UpdateRecipe();
                            recipeUpdation.updateRecipes();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            SelectOperation selectRecipe = new SelectOperation();
                            selectRecipe.selectRecipe();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        try {
                            DeleteRecipe deleteRecipe = new DeleteRecipe();
                            deleteRecipe.deleteRecipes();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 5:
                        System.out.println("Quit Application");
                        menu = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                input.next();  // Consume the invalid input
            }
        }

        input.close();  // Closing the Scanner at the end
    }
}
