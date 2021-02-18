package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScrollableDemo {

	public static void main(String[] args) {
		 Connection con; // creating connection object
	     Statement stmt; // creating statement object
	     ResultSet rs; // creating resultset object
	     
	     try {
	    	 //Register jdbc driver
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 
	    	 
	    	 // open a connection
	    	 System.out.println("Connecting to database");
	    	 
	    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Qwerty!123");
	    	 //scrollable result set
	    	 stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	    	 rs=stmt.executeQuery("select * from skills");
	    	 
	    	 // reading from bottom to top
	    	 rs.afterLast();
	    	 while(rs.previous()){
	    		 System.out.println(rs.getInt(1)+" "+rs.getString(2));
	    	 }
	    	 System.out.println("**************************************************");
	    	 //move cursor to third record
	    	 rs.absolute(3);
	    	 System.out.println(rs.getInt(1)+" "+rs.getString(2));
	    	 System.out.println("**************************************************");
	    	 
	    	 //move cursor to 2nd record using relative()
	    	 rs.relative(-1);
	    	 System.out.println(rs.getInt(1)+" "+rs.getString(2));
	    	 System.out.println("**************************************************");
	    	 
	    	 
	    	 int i=rs.getRow();// GET CURSOR POSITION
	    	 System.out.println("CURSOR POSITION="+i);
	    	 
	    	 //clean up
	    	 rs.close();
	    	 stmt.close();
	    	 con.close();
	    	 

	}
	     catch(Exception e) {
	    	 System.out.println(e);
	     }

}
}