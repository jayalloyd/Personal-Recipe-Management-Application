package com.abcd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

interface Operations{
	void  addRecipes();
	void searchRecipes();
	void deleteRecipes();
}
public class RecipesOperation implements Operations
	 {
//    public RecipesOperation() {
//    	
//    	System.out.println("Operation started");
//    }
	Connection connect=null;
    try {
	   connect = JDBCUtil.getConnection();
	  String sql;

	;
	  
	  
    }
    catch(Exception e) {
        e.printStackTrace();
       }
    catch(SQLException sqle) {
    	e.printStackTrace();
    }
public void addRecipes() {
		
	  String sql="INSERT INTO Recipe (id int AUTO_INCREMENT,dish_name varchar(30) NOT NULL,cuisine varchar(30) NOT NULL,url varchar(2083) NOT NULL,"
	  		+ "main_ingredient varchar(30) NOT NULL,PRIMARY KEY(id)) Values(?,?,?,?,?)";
	  Statement statement=connect.prepareStatement(sql);
	  System.out.println("Please enter the following data");
	  Scanner input=new Scanner(System.in);
	  System.out.println("Enter the dish name:");
	  
	  

	}
    
	

	@Override
	public void searchRecipes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRecipes() {
		// TODO Auto-generated method stub
		
	}
    }
    
}

