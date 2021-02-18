package com.valuemomentum.training.jdbcdemo;

import java.sql.*;

public class JoinsDemo {
	 public static void main( String[] args )
	    {
	     Connection con; // creating connection object
	     Statement stmt; // creating statement object
	     ResultSet rs; // creating resultset object
	     
	     try {
	    	 //Register jdbc driver
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 
	    	 
	    	 // open a connection
	    	 System.out.println("Connecting to database");
	    	 
	    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Qwerty!123");
	    	 
	    	 // Execute a query
	    	 //creating statement object using connection obj
	    	 stmt=con.createStatement();
	    	 //execute query and retrieve the data into resultset
	    	 rs=stmt.executeQuery("select c.id,first_name,name from candidates c INNER JOIN  candidate_skills s ON c.id=candidate_id  INNER JOIN  skills sk ON s.skill_id=sk.id  ;");
	    	 while(rs.next()) {
	    		 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
	    	 }rs.close();
		    	stmt.close();
		    	con.close();

	    	 
	    	 }
	     catch(Exception e) {
	    	 System.out.println(e);
	     }
	     }
}
	    	 