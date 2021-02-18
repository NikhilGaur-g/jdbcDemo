package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) {
		Connection con; // creating connection object
	     Statement stmt; // creating statement object
	     ResultSet rs; // creating resultset object
	     int cnt = 0;
	     try {
	    	 //Register jdbc driver
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 
	    	 
	    	 // open a connection
	    	 System.out.println("Connecting to database");
	    	 
	    	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Qwerty!123");
	    	 String sql="Delete from candidates where rtrim(last_name) like\'Y%g\';";
	    	 System.out.println(" ");
	    	 stmt=con.createStatement();
	    	 cnt=stmt.executeUpdate(sql);
	    	 
	    	 if(cnt>0) {
	    		 System.out.println("record for Young is deleted");
	    	 }
	    con.close();
	}
	     catch(Exception ce)
	     {System.out.println(ce);}

}}
