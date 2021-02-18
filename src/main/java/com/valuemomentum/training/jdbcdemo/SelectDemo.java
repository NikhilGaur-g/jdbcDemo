package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args) {
		Connection con; // creating connection object
	     Statement stmt; // creating statement object
	     ResultSet rs; // creating resultset object
	     
	     try {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 
	    	 System.out.println("Connecting to database");
	    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Qwerty!123");
	    	 
	    	 // Execute a query
	    	 //creating statement object using connection obj
	    	 stmt=con.createStatement();
	    	 //execute query and retrieve the data into resultset
	    	 rs=stmt.executeQuery("select * from candidates");
	    	 
	    	 
	    	//Extract data from result set
	    	 while(rs.next()) {
	    		 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "
	    				 +rs.getDate(4)+" "+rs.getString(5)+" "+rs.getString("email"));

	     }
	    	 rs.close();
		    	stmt.close();
		    	con.close();
		     }
		     catch(Exception e) {
		    	 System.out.println(e);
	}

}}
